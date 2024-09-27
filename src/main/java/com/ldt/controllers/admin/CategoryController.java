package com.ldt.controllers.admin;

import com.ldt.models.CategoryModel;
import com.ldt.services.ICategoryService;
import com.ldt.services.impl.CategoryServiceImpl;
import com.ldt.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add","/admin/category/insert","/admin/category/edit",
        "/admin/category/update","/admin/category/delete","/admin/category/search"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CategoryController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    public ICategoryService categoryService=new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (url.contains("categories")) {
            List<CategoryModel> list=categoryService.findAll();
            req.setAttribute("listcate",list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req,resp);
        } else if (url.contains("add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req,resp);
        }else if (url.contains("edit")) {
            CategoryModel categoryModel = categoryService.findById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("cate",categoryModel);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req,resp);
        }else if (url.contains("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (url.contains("insert")) {
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            CategoryModel categoryModel = new CategoryModel();
            String fname="";
            String uploadPath= Constant.UPLOAD_DIRECTORY;
            File uploadDir=new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            try{
               Part part=req.getPart("images");
                if (part.getSize()>0){
                    String fileName= Paths.get(part.getSubmittedFileName()).getFileName().toString();
//                    rename
                    int index=fileName.lastIndexOf(".");
                    String ext=fileName.substring(index);
                    fname=System.currentTimeMillis()+'.'+ext;
                    part.write(uploadPath+File.separator+fileName);
                    categoryModel.setImages(fileName);
                }
                else {
                    categoryModel.setImages("https://cdn.tgdd.vn/2023/11/content/7-800x450-4.jpg");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            categoryModel.setCategoryname(categoryname);
            categoryModel.setStatus(status);
            categoryService.insert(categoryModel);
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        } else if (url.contains("update")) {
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setCategoryid(categoryid);
            categoryModel.setCategoryname(categoryname);
            categoryModel.setStatus(status);

//            lưu hinh cu
            CategoryModel cateold=categoryService.findById(categoryid);
            String fileold=cateold.getImages();

            String fname="";
            String uploadPath= Constant.UPLOAD_DIRECTORY;
            File uploadDir=new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            try{
                Part part=req.getPart("images");
                if (part.getSize()>0){
                    String fileName= Paths.get(part.getSubmittedFileName()).getFileName().toString();
//                    rename
                    int index=fileName.lastIndexOf(".");
                    String ext=fileName.substring(index);
                    fname=System.currentTimeMillis()+'.'+ext;
                    part.write(uploadPath+File.separator+fileName);
                    categoryModel.setImages(fileName);
                }
                else {
                    categoryModel.setImages(fileold);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            categoryService.update(categoryModel);
            resp.sendRedirect(req.getContextPath()+"/admin/categories");
        }
    }
}

package com.ldt.controllers;

import com.ldt.models.CategoryModel;
import com.ldt.models.UserModel;
import com.ldt.services.IUserService;
import com.ldt.services.impl.UserServiceImpl;
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

@WebServlet(urlPatterns = {"/profile"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfileController extends HttpServlet {
    /**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;
    private IUserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = (UserModel) req.getSession().getAttribute("account");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String fullname = req.getParameter("fullname");
        String images = req.getParameter("images");


        UserModel userModel=userService.findByUsername(username);
        String fileold=userModel.getImages();
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
                userModel.setImages(fileName);
            }
            else {
                userModel.setImages(fileold);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        userModel.setFullname(fullname);
        userModel.setPhone(phone);
        userModel.setEmail(email);

        userService.updateProfile(userModel);
        req.setAttribute("user", userModel);
        req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);

    }

    String getFilename(Part part){
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}

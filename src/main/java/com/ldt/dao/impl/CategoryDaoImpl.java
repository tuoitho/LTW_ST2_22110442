package com.ldt.dao.impl;

import com.ldt.configs.DBConnectSQL;
import com.ldt.dao.ICategoryDao;
import com.ldt.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    public Connection conn = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;

    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> list = new ArrayList<>();
        try {
            conn = DBConnectSQL.getConnection();
            String sql = "SELECT * FROM categories";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            pst.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findById(int id) {
        try {
            conn = DBConnectSQL.getConnection();
            String sql = "SELECT * FROM categories WHERE categoryid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(CategoryModel categoryModel) {
        try {
            conn = DBConnectSQL.getConnection();
            String sql = "INSERT INTO categories(categoryname, images, status) VALUES(?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, categoryModel.getCategoryname());
            pst.setString(2, categoryModel.getImages());
            pst.setInt(3, categoryModel.getStatus());
            pst.executeUpdate();
            conn.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel categoryModel) {
        try {
            conn = DBConnectSQL.getConnection();
            String sql = "UPDATE categories SET categoryname = ?, images = ?, status = ? WHERE categoryid = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, categoryModel.getCategoryname());
            pst.setString(2, categoryModel.getImages());
            pst.setInt(3, categoryModel.getStatus());
            pst.setInt(4, categoryModel.getCategoryid());
            pst.executeUpdate();
            conn.close();
            pst.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try{
            conn = DBConnectSQL.getConnection();
            String sql = "DELETE FROM categories WHERE categoryid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            conn.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        List<CategoryModel> list = new ArrayList<>();
        try {
            conn = DBConnectSQL.getConnection();
            String sql = "SELECT * FROM categories WHERE categoryname LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(rs.getInt("categoryid"));
                category.setCategoryname(rs.getString("categoryname"));
                category.setImages(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                list.add(category);
            }
            conn.close();
            pst.close();
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.ldt.dao;

import com.ldt.models.CategoryModel;

import java.util.List;

public interface ICategoryDao {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    void insert(CategoryModel categoryModel);
    void update(CategoryModel categoryModel);
    void delete(int id);
    List<CategoryModel> findName(String keyword);
    void updateStatus(int id,int status);
}

package com.ldt.services;

import com.ldt.models.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    void insert(CategoryModel categoryModel);
    void update(CategoryModel categoryModel);
    void delete(int id);
    List<CategoryModel> findName(String keyword);
}

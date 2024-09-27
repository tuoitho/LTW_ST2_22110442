package com.ldt.services.impl;

import com.ldt.dao.ICategoryDao;
import com.ldt.dao.impl.CategoryDaoImpl;
import com.ldt.models.CategoryModel;
import com.ldt.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    public ICategoryDao categoryDao=new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public void insert(CategoryModel categoryModel) {
        categoryDao.insert(categoryModel);
    }

    @Override
    public void update(CategoryModel categoryModel) {
        CategoryModel category =new CategoryModel();
        category=categoryDao.findById(categoryModel.getCategoryid());
        if(category!=null){
            categoryDao.update(categoryModel);
        }
    }

    @Override
    public void delete(int id) {
        CategoryModel category =new CategoryModel();
        category=categoryDao.findById(id);
        if(category!=null){
            categoryDao.delete(id);
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        return categoryDao.findName(keyword);
    }
}

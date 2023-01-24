package test.dao;

import java.util.List;

import test.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	
	List<CategoryModel> findAll();

}

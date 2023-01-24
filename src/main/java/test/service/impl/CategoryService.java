package test.service.impl;

import java.util.List;

import javax.inject.Inject;

import test.dao.ICategoryDAO;
import test.model.CategoryModel;
import test.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	/*
	 * private ICategoryDAO categoryDao;
	 * 
	 * public CategoryService() { categoryDao = new CategoryDAO(); }
	 */
	
	@Inject
	private ICategoryDAO categoryDao;
	

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}

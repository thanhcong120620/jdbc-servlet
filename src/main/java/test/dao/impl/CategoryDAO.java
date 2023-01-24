package test.dao.impl;

import java.util.List;

import test.dao.ICategoryDAO;
import test.mapper.CategoryMapper;
import test.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{
	
	
	

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

}

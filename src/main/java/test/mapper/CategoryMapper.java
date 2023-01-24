package test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import test.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setId(resultSet.getLong("id"));
			categoryModel.setCode(resultSet.getString("code"));
			categoryModel.setName(resultSet.getString("name"));
			
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
		
	}

}

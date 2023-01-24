package test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import test.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		NewModel newModel = new NewModel();
		try {
			newModel.setId(resultSet.getLong("id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setThumbnail(resultSet.getString("thumbnail"));
			newModel.setShortDescription(resultSet.getString("shortdescription"));
			newModel.setContent(resultSet.getString("content"));
			newModel.setCategoryId(resultSet.getLong("categoryid"));
			newModel.setCreatedBy(resultSet.getString("createdby"));
			newModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			newModel.setModifiedBy(resultSet.getString("modifiedby"));
			newModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
//			newModel.setCategoryCode(resultSet.getString("name"));	
			
			return newModel;
		} catch (SQLException e) {
			return null;
		}

		
	}

}

package test.dao.impl;

import java.util.List;

import test.dao.INewDAO;
import test.mapper.NewMapper;
import test.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO{

	
/*------------------Find one + Find by-List(Use statement.executeQuery)------------------*/
	
	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		
		return news.isEmpty() ? null : news.get(0);
	
	}
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		
		return query(sql, new NewMapper(), categoryId);
	}
	
	
	
	
/*------------------Save + Update + Delete(Use statement.executeUpdate)------------------*/	

	/*
	 * Use common method
	 * */
	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), 
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getModifiedDate(), 
				updateNew.getModifiedBy(), updateNew.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	/*
	 * Not use common method
	 * */
//	@Override
//	public Long save(NewModel newModel) {
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		Long id = null;
//		try {
//			String sql = "INSERT INTO news (title, content, categoryid) VALUES (?,?,?)";
//			connection = getConnection();
//			connection.setAutoCommit(false);
//			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
//			statement.setString(1,newModel.getTitle());
//			statement.setString(2,newModel.getContent());
//			statement.setLong(3,newModel.getCategoryId());
//			
//			statement.executeUpdate();
//			resultSet = statement.getGeneratedKeys();
//			
//			if(resultSet.next()) {
//				id = resultSet.getLong(1);  // 1 is index of column number one in database
//			}
//			
//			connection.commit();
//			
//			return id;
//			
//		} catch(SQLException e) {
//			if(connection != null) {
//				try {
//					connection.rollback();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//			return null;
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//				if (resultSet != null) {
//					resultSet.close();
//				}
//			} catch (SQLException e) {
//				return null;
//			}
//		}
//		
//	}

}

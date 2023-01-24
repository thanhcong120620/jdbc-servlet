package test.dao;

import java.util.List;

import test.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel>  {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel); // return id of this newModel
	void update(NewModel updateModel);
	void delete(long id);
}

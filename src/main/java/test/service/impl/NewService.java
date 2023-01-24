package test.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import test.dao.INewDAO;
import test.model.NewModel;
import test.service.INewService;

public class NewService implements INewService {
	
	@Inject
	private INewDAO newDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis())); 
		newModel.setCreatedBy("");
		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setModifiedBy("");
		Long newId = newDao.save(newModel);
//		System.out.println("newId: "+newId);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		
		newDao.update(updateNew);
		
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			newDao.delete(id);
		}
	}

}

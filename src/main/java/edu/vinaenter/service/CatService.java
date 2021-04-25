package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CatDao;
import edu.vinaenter.model.Category;

@Service
public class CatService implements ICRUDService<Category>{

	@Autowired
	private CatDao catDAO;
	@Override
	public List<Category> getAll() {
		
		return catDAO.getAll();
	}

	@Override
	public int update(Category t) {
		return catDAO.update(t);
	}

	@Override
	public int save(Category t) {
		return catDAO.save(t);
	}

	@Override
	public int del(int id) {
		return catDAO.del(id);
	}

	@Override
	public Category findOne(Category t) {
		return null;
	}



	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return catDAO.findByid(id);
	}

	@Override
	public List<Category> getAll(int offset, int rowcount) {
		// TODO Auto-generated method stub
		return catDAO.getAll(offset,rowcount);
	}



	@Override
	public List<Category> getByName(int offset, int rowcount, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalRow() {
		// TODO Auto-generated method stub
		return catDAO.getTotalRow();
	}

	public List<Category> getAll(int offset, int totalRow, String searchname) {
		// TODO Auto-generated method stub
		return catDAO.getAll(offset,totalRow,searchname);
	}



}
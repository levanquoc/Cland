package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.RolesDao;
import edu.vinaenter.model.Roles;
@Service
public class RolesService implements ICRUDService<Roles> {
	@Autowired
	private RolesDao rolesDao;
	@Override
	public List<Roles> getAll() {
		// TODO Auto-generated method stub
		return rolesDao.getAll();
	}

	@Override
	public int update(Roles t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Roles t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Roles findOne(Roles t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getAll(int offset, int rowcount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getByName(int offset, int rowcount, String name) {
		// TODO Auto-generated method stub
		return null;
	}



}

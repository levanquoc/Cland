package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDao;
import edu.vinaenter.model.User;
@Service

public class UserService implements ICRUDService<User> {
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return userDao.update(t);
	}

	@Override
	public int save(User t) {
		// TODO Auto-generated method stub
		return userDao.save(t);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return userDao.del(id);
	}

	@Override
	public User findOne(User t) {
		// TODO Auto-generated method stub
		return userDao.findOne(t);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findByid(id);
	}

	@Override
	public List<User> getAll(int offset, int rowcount) {
		// TODO Auto-generated method stub
		return userDao.getAll(offset,rowcount);
	}

	@Override
	public List<User> getByName(int offset, int rowcount, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalRow() {
		// TODO Auto-generated method stub
		return userDao.getTotalRow();
	}

	public List<User> getAll(int offset, int totalRow, String namesearch) {
		// TODO Auto-generated method stub
		return userDao.getAll(offset,totalRow,namesearch);
	}



}

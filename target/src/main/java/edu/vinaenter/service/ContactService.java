package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.ContactDao;
import edu.vinaenter.model.Contact;

@Service

public  class ContactService implements ICRUDService<Contact>{

	@Autowired
	private ContactDao contactDao;
	@Override
	public List<Contact> getAll() {
		
		return contactDao.getAll();
	}
	@Override
	public List<Contact> getAll(int offset, int rowcount) {
		// TODO Auto-generated method stub
		return contactDao.getAll(offset, rowcount);
	}
	@Override
	public int update(Contact t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int save(Contact t) {
		// TODO Auto-generated method stub
		return contactDao.save(t);
	}
	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return contactDao.del(id);
	}
	@Override
	public Contact findOne(Contact t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Contact findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Contact> getByName(int offset, int rowcount, String name) {
		// TODO Auto-generated method stub
		return contactDao.getByName(offset, rowcount, name);
	}
	public int getTotalRow() {
		// TODO Auto-generated method stub
		return contactDao.getTotalRow();
	}

	
	
}
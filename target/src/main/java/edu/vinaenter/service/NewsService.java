package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.NewsDao;
import edu.vinaenter.model.News;
@Service
public class NewsService implements ICRUDService<News>{
	@Autowired
	private NewsDao newsDao;
	@Override
	public List<News> getAll(int offset,int rowCount) {
		// TODO Auto-generated method stub
		return newsDao.getAll(offset,rowCount);
	}

	@Override
	public int update(News t) {
		// TODO Auto-generated method stub
		return newsDao.update(t);
	}

	@Override
	public int save(News t) {
		// TODO Auto-generated method stub
		return newsDao.save(t);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return newsDao.del(id);
	}

	@Override
	public News findOne(News t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News findById(int id) {
		// TODO Auto-generated method stub
		return newsDao.findByid(id);
	}

	@Override
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return newsDao.getAll();
	}

	

	@Override
	public List<News> getByName(int offset, int rowcount, String name) {
		// TODO Auto-generated method stub
		return newsDao.getByName(offset,rowcount,name);
	}

	public List<News> getByCategory(int offset,int rowcount, int cid) {
		// TODO Auto-generated method stub
		return newsDao.getByCategory(offset,rowcount,cid);
	}

	public int totalRow() {
		return newsDao.totalRow();
	}

	public List<News> getByCategoryByName(int offset, int rowcount, int cid, String namesearch) {
		// TODO Auto-generated method stub
		return newsDao.getByCategoryByName( offset, rowcount, cid,  namesearch);
	
	}

	public int getTotalRow() {
		// TODO Auto-generated method stub
		return newsDao.getTotalRow();
	}

}

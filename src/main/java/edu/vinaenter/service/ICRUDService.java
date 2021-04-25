package edu.vinaenter.service;

import java.util.List;

public interface ICRUDService<T> {
	List<T> getAll();

	List<T> getAll(int offset, int rowcount);

	int update(T t);

	int save(T t);

	int del(int id);

	T findOne(T t);

	T findById(int id);

	List<T> getByName(int offset,int rowcount,String name);

}

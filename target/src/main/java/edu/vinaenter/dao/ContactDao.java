package edu.vinaenter.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Contact;

@Repository
public class ContactDao extends AbstractDao<Contact>{
	@Override
	public List<Contact> getAll(int offset,int rowcount){
		final String SQL="SELECT * FROM vnecontact ORDER BY id DESC LIMIT ?,?";
		return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Contact.class),offset,rowcount);
	}
	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM vnecontact WHERE id = ?";
		return jdbcTemplate.update(SQL, id);
	}
	
	@Override
	
	public int save(Contact t) {
		final String SQL = "INSERT INTO vnecontact (name,email,subject,content) VALUES (?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getName(),t.getEmail(),t.getSubject(),t.getContent());
	}
	/*
	@Override
	public Category findByid(int id) {
		final String SQL="SELECT * FROM categories  WHERE cid=?";
		return jdbcTemplate.queryForObject(SQL,new BeanPropertyRowMapper<>(Category.class),id);
	}
	@Override
	public int update(Category t) {
		final String SQL = "UPDATE categories SET cname = ? WHERE cid = ? ";
		return jdbcTemplate.update(SQL, t.getCname(), t.getCid());
	}
*/
	@Override
	public List<Contact> getByName(int offset, int rowcount, String name) {
		final String SQL="SELECT * FROM vnecontact WHERE subject LIKE ? ORDER BY id DESC LIMIT ?,?";
		return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Contact.class),"%"+name+"%",offset,rowcount);
	}
	public int getTotalRow() {
		final String SQL = "SELECT COUNT(*) totalROW FROM vnecontact";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}
}

package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Roles;
import edu.vinaenter.model.User;
@Repository
public class UserDao extends AbstractDao<User>{
	@Override
	public List<User> getAll(int offset,int rowcount) {
		final String SQL="SELECT u.*,r.name FROM users as u INNER JOIN roles as r ON u.roleId=r.id ORDER BY u.id DESC LIMIT ?,? ";
		return jdbcTemplate.query(SQL,new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user= new User(rs.getInt("id"),rs.getString("username"),rs.getString("fullname"),rs.getNString("password"),new Roles(rs.getInt("roleId"),rs.getString("name")));
				return user;
			}
			
		},offset,rowcount);
		
	}
	@Override
	public int save(User t) {
		final String SQL="INSERT INTO users (username,fullname,roleId,password) VALUES(?,?,?,?)";
		return jdbcTemplate.update(SQL,t.getUsername(),t.getFullname(),t.getRoles().getId(),t.getPassword());
	}
	@Override
	public int update(User t) {
		final String SQL="UPDATE users SET fullname=?,password=?,roleId=? WHERE id=?";
		return jdbcTemplate.update(SQL,t.getFullname(),t.getPassword(),t.getRoles().getId(),t.getId());
	}
	@Override
	public int del(int id) {
		
		final String SQL="DELETE FROM users WHERE id=?";
		return jdbcTemplate.update(SQL,id);
	}
	@Override
	public User findByid(int id) {
		
		final String SQL="SELECT u.*,r.name FROM users as u INNER JOIN roles as r ON u.roleId=r.id WHERE u.id=? ";
		return jdbcTemplate.queryForObject(SQL,new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user= new User(rs.getInt("id"),rs.getString("username"),rs.getString("fullname"),rs.getNString("password"),new Roles(rs.getInt("roleId"),rs.getString("name")));
				return user;
			}
			
		},id);
	}
	public int getTotalRow() { 
		final String SQL = "SELECT COUNT(*) totalROW FROM users as u INNER JOIN roles as r ON u.roleId=r.id";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}
	public List<User> getAll(int offset, int totalRow, String namesearch) {
		final String SQL="SELECT u.*,r.name FROM users as u INNER JOIN roles as r ON u.roleId=r.id  WHERE u.username LIKE ? ORDER BY u.id DESC LIMIT ?,? ";
		return jdbcTemplate.query(SQL,new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user= new User(rs.getInt("id"),rs.getString("username"),rs.getString("fullname"),rs.getNString("password"),new Roles(rs.getInt("roleId"),rs.getString("name")));
				return user;
			}
			
		},"%"+namesearch+"%",offset,totalRow);
	}

	}



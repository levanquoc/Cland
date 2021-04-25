package edu.vinaenter.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Roles;
@Repository
public class RolesDao extends AbstractDao<Roles> {
	@Override
	public List<Roles> getAll() {
		final String SQL="SELECT * FROM roles ORDER BY id DESC";
		return jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Roles.class));
	}

}

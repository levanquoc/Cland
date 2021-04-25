package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.model.Category;
import edu.vinaenter.model.News;

@Repository
public class NewsDao extends AbstractDao<News> {

	@Override
	public List<News> getAll(int offset, int rowCount) {
		final String SQL = "SELECT l.*,c.cname FROM lands as l INNER JOIN categories as c WHERE l.cid=c.cid ORDER BY l.lid DESC LIMIT ?,?";
		return jdbcTemplate.query(SQL, new RowMapper<News>() {

			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getString("detail"), rs.getTimestamp("date_create"),
						new Category(rs.getInt("cid"), rs.getString("cname")), rs.getString("picture"),
						rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				return news;
			}

		}, offset, rowCount);
	}

	@Override
	public int save(News t) {
		final String SQL = "INSERT INTO lands(lname, description, detail,cid, picture, area,address) VALUES (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getDetail(), t.getCategory().getCid(),
				t.getPicture(), t.getArea(), t.getAddress());
	}

	public int totalRow() {
		final String SQL = "SELECT COUNT(*) totalROW FROM lands as l INNER JOIN categories as c ON l.cid=c.cid";
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	@Override
	public int del(int id) {
		final String SQL = "DELETE FROM lands WHERE lid=? ";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public News findByid(int id) {
		final String SQL = "SELECT l.*,c.cname FROM lands as l INNER JOIN categories as c ON l.cid=c.cid WHERE l.lid=? ";
		return jdbcTemplate.queryForObject(SQL, new RowMapper<News>() {

			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getString("detail"), rs.getTimestamp("date_create"),
						new Category(rs.getInt("cid"), rs.getString("cname")), rs.getString("picture"),
						rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				return news;
			}

		}, id);
	}

	@Override
	public int update(News t) {
		final String SQL = "UPDATE lands SET lname=?,description=?,detail=?,cid=?,picture=?,area=?,address=?  WHERE lid=?";
		return jdbcTemplate.update(SQL, t.getLname(), t.getDescription(), t.getDetail(), t.getCategory().getCid(),
				t.getPicture(), t.getArea(), t.getAddress(), t.getLid());
	}

	@Override
	public List<News> getByName(int offset, int rowcount, String name) {
		final String SQL = "SELECT l.*,c.cname FROM lands as l INNER JOIN categories as c ON l.cid=c.cid WHERE lname LIKE ? LIMIT ?,?";
		return jdbcTemplate.query(SQL, new RowMapper<News>() {

			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getString("detail"), rs.getTimestamp("date_create"),
						new Category(rs.getInt("cid"), rs.getString("cname")), rs.getString("picture"),
						rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				return news;
			}

		},"%"+name+"%",offset,rowcount);

}

	public List<News> getByCategory(int offset, int rowcount, int cid) {
		final String SQL = "SELECT l.*,c.cname FROM lands as l INNER JOIN categories as c ON l.cid=c.cid WHERE l.cid=? LIMIT ?,?";
		return jdbcTemplate.query(SQL, new RowMapper<News>() {

			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getString("detail"), rs.getTimestamp("date_create"),
						new Category(rs.getInt("cid"), rs.getString("cname")), rs.getString("picture"),
						rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				return news;
			}

		},cid,offset,rowcount);
	}

	public List<News> getByCategoryByName(int offset, int rowcount, int cid, String namesearch) {
		final String SQL = "SELECT l.*,c.cname FROM lands as l INNER JOIN categories as c ON l.cid=c.cid WHERE l.cid=? AND l.lname LIKE ? LIMIT ?,?";
		return jdbcTemplate.query(SQL, new RowMapper<News>() {

			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"),
						rs.getString("detail"), rs.getTimestamp("date_create"),
						new Category(rs.getInt("cid"), rs.getString("cname")), rs.getString("picture"),
						rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				return news;
			}

		},cid,"%"+namesearch+"%",offset,rowcount);
	}

	public int getTotalRow() {
		final String SQL=" SELECT COUNT(*) TotalRow FROM lands";
		return jdbcTemplate.queryForObject(SQL,Integer.class);
	}
}	

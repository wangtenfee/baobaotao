package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	public int getMatchCount(String userName, String password) {
		String sqlStr = " SELECT count(*) FROM x_user "
				+ " WHERE username =? and password=? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] { userName, password });
	}

	public User findUserByUserName(final String userName) {
		String sqlStr = " SELECT userid,username,credits "
				+ " FROM x_user WHERE username =? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("userid"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));
					} 
				});
		return user;
	}

	public void updateLoginInfo(User user) {
		String sqlStr = " UPDATE x_user SET lastvisit=?,lastip=?,credits=? "
				+ " WHERE userid =?";
		jdbcTemplate.update(sqlStr, new Object[] { user.getLastVisit(),
				user.getLastIp(),user.getCredits(),user.getUserId()});
	}
	
	public void insertUser(String username,String password) {
		String strSql = " insert into x_user(username,password) "
				+ " values(?,?) ";
		jdbcTemplate.update(strSql, new Object[]{username,password});
	}
}

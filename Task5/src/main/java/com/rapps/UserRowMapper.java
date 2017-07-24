package com.rapps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rapps.model.UserModel;

public class UserRowMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserModel user = new UserModel();

		user.setUserId(rs.getLong("user_id"));
		user.setUserName(rs.getString("username"));
		user.setGender(rs.getString("gender"));
		

		return user;
	}

}
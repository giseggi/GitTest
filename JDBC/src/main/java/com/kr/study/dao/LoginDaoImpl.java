package com.kr.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kr.study.dto.UserInfoDto;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	DataSource ds;
	
	@Override
	public String function(UserInfoDto dto) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		String sql = "select id from user_info where id = ? and password = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		rs.last();

		try {
			String id = rs.getString("id");
			
			return id;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
		
	}

}

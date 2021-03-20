package com.kr.study.dao;

import java.sql.SQLException;

import com.kr.study.dto.UserInfoDto;

public interface LoginDao {

	public String function(UserInfoDto dto) throws SQLException;
}

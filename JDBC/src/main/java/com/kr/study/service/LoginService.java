package com.kr.study.service;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.kr.study.dto.UserInfoDto;

public interface LoginService {

	public ModelAndView function(UserInfoDto dto) throws SQLException;
	
}

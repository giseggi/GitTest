package com.study.mybatis.service;

import org.springframework.web.servlet.ModelAndView;

import com.study.mybatis.dto.UserInfoDto;

public interface LoginService {

	public ModelAndView function(UserInfoDto dto);
	
}

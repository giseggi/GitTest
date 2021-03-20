package com.kr.study.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kr.study.dto.UserInfoDto;
import com.kr.study.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="loginCheck")
	public ModelAndView loginCheck(@ModelAttribute("name") UserInfoDto dto) throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		mv = service.function(dto);
		
		return mv;
	}

}

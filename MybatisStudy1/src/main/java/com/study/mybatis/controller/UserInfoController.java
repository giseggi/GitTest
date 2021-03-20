package com.study.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.mybatis.service.UserInfoService;

@Controller
public class UserInfoController {
	
	@Autowired
	UserInfoService service;
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo() {
		
		ModelAndView mv = new ModelAndView();
		
		mv = service.userInfo();
		
		return mv;
	}

}

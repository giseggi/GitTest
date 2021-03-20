package com.study.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.mybatis.dto.UserInfoDto;
import com.study.mybatis.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="loginCheck")
	public ModelAndView loginCheck(@ModelAttribute("name") UserInfoDto dto) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("컨트롤러 시점의 id : " + dto.getId());
		System.out.println("컨트롤러 시점의 password : " + dto.getPassword());
		
		mv = service.function(dto);
		
		return mv;
	}

}

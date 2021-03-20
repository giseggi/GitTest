package com.study.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.study.mybatis.dao.LoginDao;
import com.study.mybatis.dto.UserInfoDto;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;
	
	@Override
	public ModelAndView function(UserInfoDto dto) {
		
		ModelAndView mv = new ModelAndView();
		
		String result = dao.function(dto);
		
		if("admin".equals(result)) {
			mv.setViewName("redirect:/userInfo");
		} else if (result != null) {
			mv.addObject("msg", result +"님 환영합니다.");
			mv.setViewName("test");
		} else {
			mv.addObject("msg", "오류입니다.");
			mv.setViewName("home");
		}
		
		return mv;
	}

}

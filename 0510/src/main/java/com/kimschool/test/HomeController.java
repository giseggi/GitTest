package com.kimschool.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kr.study.dto.TestBoard;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	@RequestMapping(value = "/")
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView("home");
		
		
		return mv;
	}
	
	@RequestMapping(value = "test")
	public ModelAndView result(String msg) {

		ModelAndView mv = new ModelAndView("result");
		
		mv.addObject("msg", msg);
		
		
		return mv;
	}
	
	@RequestMapping(value = "moveboard")
	public ModelAndView moveboard() throws ClassNotFoundException, SQLException {
		
		String id = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
				
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url, id, password);
		
		String sql = "select * from test_board";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<TestBoard> dtoList = new ArrayList<TestBoard>();
		
		while(rs.next()) {
			
			TestBoard dto = new TestBoard();
			
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setU_name(rs.getNString("u_name"));
			dto.setHit(rs.getInt("hit"));
			
			dtoList.add(dto);
			
		}
		
		ModelAndView mv = new ModelAndView("board");
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
	}
	
}

package com.kimschool.review;

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

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.review.entity.CharInfoDto;
import com.kimschool.review.entity.TestBoard;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	DataSource ds;
	

	@RequestMapping(value = "/")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("first");
		
		return mv;
	
	}
	
	
	@RequestMapping(value = "moveresult")
	public ModelAndView moveresult(@RequestParam("msg") String mssg) {
		
		ModelAndView mv = new ModelAndView("result");
		
		mv.addObject("msg", mssg);
		
		return mv;
	
	}
	
	@RequestMapping(value = "db")
	public ModelAndView db() throws ClassNotFoundException, SQLException {
		
//		String url = "jdbc:mysql://localhost:3306/test";
//		String id = "root";
//		String password = "";
		
//		Class.forName("com.mysql.jdbc.Driver");
		
		//jdbc를 이용한 DB접속
		Connection conn = ds.getConnection();
		
		String sql = "select * from char_info where c_lv > ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, 20);
		
		ResultSet rs = ps.executeQuery();
		
		List<CharInfoDto> dtoList = new ArrayList<CharInfoDto>();
		
		while(rs.next()) {
			
			CharInfoDto dto = new CharInfoDto();
			
			dto.setC_id(rs.getString("c_id"));
			dto.setC_lv(rs.getInt("c_lv"));
			dto.setC_class(rs.getString("c_class"));
			
			dtoList.add(dto);
			
			
		}
		
		ModelAndView mv = new ModelAndView("third");
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "db2")
	public ModelAndView db2() throws ClassNotFoundException, SQLException {
		
//		String url = "jdbc:mysql://localhost:3306/test";
//		String id = "root";
//		String password = "";
		
//		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = ds.getConnection();
		
		String sql = "select * from test_board";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<TestBoard> dtoList = new ArrayList<TestBoard>();
		
		while(rs.next()) {
			
			TestBoard dto = new TestBoard();
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setU_name(rs.getString("u_name"));
			dto.setHit(rs.getInt("hit"));
			dto.setReg_date(rs.getString("reg_date"));
//			dto.setAuth(rs.getString("auth"));
			
			
			if("0".equals(rs.getString("auth"))) {
				dto.setAuth("예비회원");
			}
			
			else if ("1".equals(rs.getString("auth"))) {
				
				dto.setAuth("일반회원");	
			}
			else if ("2".equals(rs.getString("auth"))) {
				
				dto.setAuth("우등회원");	
			}
			
			else if ("3".equals(rs.getString("auth"))) {
				
				dto.setAuth("관리자");	
			}
			
			else if ("4".equals(rs.getString("auth"))) {
				
				dto.setAuth("KIMSCHOOL");	
			}
			
			else {
				dto.setAuth("");
				
			}
			
			dtoList.add(dto);
			
			
		}
		
		ModelAndView mv = new ModelAndView("4th");
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
		
	}
	
	
	
	
	@RequestMapping(value = "test1")
	public List<TestBoard> test1() throws ClassNotFoundException, SQLException {
		
//		String url = "jdbc:mysql://localhost:3306/test";
//		String id = "root";
//		String password = "";
		
//		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = ds.getConnection();
		
		String sql = "select * from test_board";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<TestBoard> dtoList = new ArrayList<TestBoard>();
		
		while(rs.next()) {
			
			TestBoard dto = new TestBoard();
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setU_name(rs.getString("u_name"));
			dto.setHit(rs.getInt("hit"));
			dtoList.add(dto);
			
			
		}
		

		
		return dtoList;
		
	}
	
	@RequestMapping("movewritetestboard")
	   public String movewirtetestboard() {
	      
	      return "writetestboard";
	   }
	   
	   @RequestMapping("writetestboard")
	   public ModelAndView wirtetestboard(String u_name, String title, int hit, String content) throws SQLException {
	      
	      Connection conn = ds.getConnection();
	      
	      String sql = "insert into test_board (u_name, title, hit, content) values (?, ?, ?, ?) ";
	      
	      PreparedStatement ps = conn.prepareStatement(sql);
	      
	      ps.setString(1, u_name);
	      ps.setString(2, title);
	      ps.setInt(3, hit);
	      ps.setString(4, content);
	      
	      ps.executeUpdate();
	      
	      ModelAndView mv = new ModelAndView("redirect:/db2");
	      
	      return mv;
	   }
	   
	   
	   public void insertboard(String u_name, String title, int hit, String content, String auth) throws SQLException {
	      
	      Connection conn = ds.getConnection();
	      
	      String sql = "insert into test_board (u_name, title, hit, content, auth) values (?, ?, ?, ?, ?) ";
	      
	      PreparedStatement ps = conn.prepareStatement(sql);
	      
	      ps.setString(1, u_name);
	      ps.setString(2, title);
	      ps.setInt(3, hit);
	      ps.setString(4, content);
	      ps.setString(5, auth);
	      
	      ps.executeUpdate();
	      
	      

	   }
	   
	   public void removetable() throws SQLException {
		      
		      Connection conn = ds.getConnection();
		      
		      String sql = "truncate table test_board";
		      
		      PreparedStatement ps = conn.prepareStatement(sql);
		      
		      ps.executeUpdate();
	
			      
		   }
	
}

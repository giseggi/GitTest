package com.gsg.homework;

import java.sql.Connection;
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
import org.springframework.web.servlet.ModelAndView;

import com.gsg.homwork.entity.Board;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	DataSource ds;
	
	
	
	@RequestMapping(value = "/")
	public ModelAndView home() throws SQLException {
		
		
		Connection conn = ds.getConnection();
		
		String sql = "select no, title, u_name, reg_date from board";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Board> dtoList = new ArrayList<Board>();
		
		while(rs.next()) {
			
			Board dto = new Board();
			
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setU_name(rs.getString("u_name"));
			//dto.setContents(rs.getString("contents"));
			dto.setReg_date(rs.getString("reg_date"));
			
			dtoList.add(dto);
			
		}
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
	}
	
	@RequestMapping(value = "moveregboard")
	public ModelAndView moveregboard() {
		
		ModelAndView mv = new ModelAndView("regboard");
		
		return mv;
		
	}
	
	@RequestMapping(value = "reg")
	public ModelAndView reg(String title, String u_name, String contents) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		conn.setAutoCommit(false);
		
		String sql = "insert into board(title, u_name, contents) values(?, ?, ?)";
		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, title);
		ps.setString(2, u_name);
		ps.setString(3, contents);
		
		int rs = ps.executeUpdate();
		
		if(rs > 0) {
			
			conn.commit();
		}
		else {
			
			conn.rollback();
		}
		
		ModelAndView mv = new ModelAndView("redirect:/");
		
		return mv;
		
	}
	
	@RequestMapping(value = "movelogin")
	public ModelAndView movelogin() {
		
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
		
	}
	
	@RequestMapping(value = "logincheck")
	public ModelAndView logincheck(String u_name, String password) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		String sql = "select count(*) count from board_user where u_name = ? and password = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, u_name);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		rs.last();

		int result = rs.getInt("count");
		
		ModelAndView mv = new ModelAndView("result");
		
		mv.addObject("result", result);
		
		mv.addObject("u_name", u_name);
		
		return mv;
		
	}
	
}

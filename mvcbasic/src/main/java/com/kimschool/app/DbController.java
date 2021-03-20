package com.kimschool.app;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.app.entity.CharDetailDto;
import com.kimschool.app.entity.CharInfoDto;

@Controller
public class DbController {
	
	@RequestMapping(value = "/")
	public ModelAndView db() throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result");
		
		String id = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, id, password);
		
		//SQL작성
		String sql = "select * from char_info";
		
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		ResultSet rs = ps.executeQuery();
		
		List<CharInfoDto> dtoList = new ArrayList<CharInfoDto>();
		
		//결과값이 들어있는 ResultSet객체로 부터 데이터 빼내기
		//next()메소드
		//ResultSet 객체가 있으면 true 없으면 false를 반환
		while(rs.next())  {
			CharInfoDto dto = new CharInfoDto();
			dto.setC_class(rs.getString("c_class"));
			dto.setC_id(rs.getString("c_id"));
			dto.setC_lv(rs.getInt("c_lv"));
			
			dtoList.add(dto);
			
		}
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
		
		
	}
	
	

}

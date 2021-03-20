package com.gsg.app;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gsg.app.entity.CharDetailDto;
import com.gsg.app.entity.CharInfoDto;
import com.gsg.app.entity.FileDto;
import com.gsg.app.entity.ResultVo;


@Controller
public class ResultController {

	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
	
	@RequestMapping(value = "/result")
	public ModelAndView result() {
		logger.info("결과로그");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		mv.addObject("str", "Hello");
		mv.addObject("num", 1);
		mv.addObject("bool", true);
		
		String[] strarr = new String[3]; 
		strarr[0] = "첫";
		strarr[1] = "둘";
		strarr[2] = "셋";
		
		mv.addObject("strarr", strarr);
		
		
		List<String> strlist = new ArrayList<String>();
		
		strlist.add("리1");
		strlist.add("리2");
		strlist.add("리3");
		
		
		
		
		mv.addObject("strlist", strlist);
		
		ResultVo resultvo = new ResultVo();
		resultvo.setName("이름");
		resultvo.setAge(18);
		resultvo.setMarried(false);
		
		mv.addObject("bean", resultvo);
		
		
		
		ResultVo resultvo0 = new ResultVo();
		resultvo0.setName("name");
		resultvo0.setAge(18);
		resultvo0.setMarried(false);
		
		
		ResultVo resultvo1 = new ResultVo();
		resultvo1.setName("2이름");
		resultvo1.setAge(28);
		resultvo1.setMarried(false);
		
		ResultVo resultvo2 = new ResultVo();
		resultvo2.setName("3이름");
		resultvo2.setAge(38);
		resultvo2.setMarried(true);
		
		List<ResultVo> beanlist = new ArrayList<ResultVo>();
		
		beanlist.add(resultvo0);
		beanlist.add(resultvo1);
		beanlist.add(resultvo2);
		
		mv.addObject("beanlist", beanlist);
		
		return mv;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView db() throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView("dbtest");
		
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
		
		while(rs.next()) {
			
			CharInfoDto dto = new CharInfoDto();
			dto.setC_id(rs.getString("c_id"));
			dto.setC_lv(rs.getInt("c_lv"));
			dto.setC_class(rs.getString("c_class"));
			
			dtoList.add(dto);
			
			
		}
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
		
		
	}
	
	@RequestMapping(value = "/dbdetail")
	public ModelAndView dbdetail(String id) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView("detail");
		
		String dbid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, dbid, password);
				
		//SQL작성
		String sql1 = "select * from char_detail where c_id = ?" ;
		String sql2 = "update char_detail set views = ? where c_id = ?";
		
		
				
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);	
		
		
		ps1.setString(1, id);
		
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		
		ResultSet rs1 = ps1.executeQuery();
		
		rs1.last();
		
		CharDetailDto dto = new CharDetailDto();
		
		dto.setViews(rs1.getInt("views") + 1);
		dto.setNo(rs1.getInt("no"));
		dto.setC_id(rs1.getString("c_id"));
		dto.setGold(rs1.getInt("gold"));
		dto.setHunting_count(rs1.getInt("hunting_count"));
		dto.setReg_date(rs1.getString("reg_date"));
		dto.setMod_date(rs1.getString("mod_date"));
			
		ps2.setInt(1, rs1.getInt("views") + 1);
		ps2.setString(2, id);
		
		
		int rs2 = ps2.executeUpdate();
		
		
		mv.addObject("dto", dto);
		
		
		return mv;
	}
	
	@RequestMapping(value = "/moveregcharinfo")
	public ModelAndView moveregcharinfo() {
		
		ModelAndView mv = new ModelAndView("regcharinfo");
		
		return mv;
	}
	
	@RequestMapping(value = "/regcharinfo")
	public ModelAndView regcharinfo(String c_id, int c_lv, String c_class, int gold, int hunting_count) throws ClassNotFoundException, SQLException {
		
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
		conn.setAutoCommit(false);
				
		//SQL작성
		
		String sql1 = "insert into char_info values(?, ?, ?)";
		String sql2 = "insert into char_detail(c_id, gold, hunting_count) values(?, ?, ?)";
		
		
				
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		//SQL문에 파라메터 삽입하기
		//1부터 시작
		ps1.setString(1, c_id);
		ps1.setInt(2, c_lv);
		ps1.setString(3, c_class);
		
		ps2.setString(1, c_id);
		ps2.setInt(2, gold);
		ps2.setInt(3, hunting_count);
		
		
		//SQL문을 DB에 전송 후 결과값을 rs에 삽입
		int rs1 = ps1.executeUpdate();
		int rs2 = ps2.executeUpdate();
		
		if(rs1 > 0 && rs2 > 0) {
			//insert 레코드 수가 두 테이블 모두 0이상인 경우 커밋
			conn.commit();
		}
		else {
			//아니면 롤백
			conn.rollback();
		}
		
		
		
		ModelAndView mv = new ModelAndView("redirect:/db");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/delcharinfo")
	public ModelAndView deletecharinfo(String c_id) throws ClassNotFoundException, SQLException {
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
		//자동커밋 방지
		conn.setAutoCommit(false);
				
		//SQL작성
		
		String sql1 = "delete from char_info where c_id = ? ";
		String sql2 = "delete from char_detail where c_id = ?";
		
		//SQL문을 DB에 전송하기(1/3)
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		//SQL문에 파라메터 삽입(2/3)
		//1부터 시작
		ps1.setString(1, c_id);
		ps2.setString(1, c_id);
		
		//SQL문 DB로 전송후 결과값을 rs에 삽입
		int rs1 = ps1.executeUpdate();
		int rs2 = ps2.executeUpdate();
		
		if(rs1 > 0 && rs2 > 0) {
			//delete대상 레코드가 두 테이블 모두 0이상인 경우 커밋
			conn.commit();
		}
		else {
			//아니면 롤백
			conn.rollback();
		}
		
		
		ModelAndView mv = new ModelAndView("redirect:/db");
		
		return mv;
	}
	
	@RequestMapping(value = "/movemodcharinfo")
	public ModelAndView movemodcharinfo(String id) throws ClassNotFoundException, SQLException {
		
		
		String dbid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, dbid, password);
				
		//SQL작성
		String sql = "select * from char_detail where c_id = ?";
		
	
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, id);
				
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		ResultSet rs = ps.executeQuery();
		
		rs.last();
		
		CharDetailDto dto = new CharDetailDto();
	
		dto.setNo(rs.getInt("no"));
		dto.setC_id(rs.getString("c_id"));
		dto.setGold(rs.getInt("gold"));
		dto.setHunting_count(rs.getInt("hunting_count"));
		dto.setReg_date(rs.getString("reg_date"));
		dto.setMod_date(rs.getString("mod_date"));	
		
		
		ModelAndView mv = new ModelAndView("moddetail");
		
		mv.addObject("dto", dto);
	
		return mv;
		
	}
	
	
	@RequestMapping(value = "/modcharinfo")
	public ModelAndView modcharinfo(String id, int gold, int hunting_count) throws ClassNotFoundException, SQLException {
		
		String dbid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, dbid, password);
				
		//SQL작성
		String sql = "update char_detail set gold = ?, hunting_count =?, mod_date = now() where c_id = ? ";
		
	
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, gold);
		ps.setInt(2, hunting_count);
		ps.setString(3, id);
				
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		int rs = ps.executeUpdate();
		
		
		ModelAndView mv = new ModelAndView("redirect://");
		
		return mv;
		
	}
	
	@RequestMapping(value = "/searchbycategory")
	public ModelAndView searchbyid(String category, String search) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView("dbtest");
		
		String id = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, id, password);
				
		//SQL작성
		String sql = "select * from char_info where " + category + " like ?";
				
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + search + "%");
				
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		ResultSet rs = ps.executeQuery();
				
		List<CharInfoDto> dtoList = new ArrayList<CharInfoDto>();
				
		//결과값이 들어있는 ResultSet객체로 부터 데이터 빼내기
		//next()메소드
		//ResultSet 객체가 있으면 true 없으면 false를 반환
		
		while(rs.next()) {
			
			CharInfoDto dto = new CharInfoDto();
			dto.setC_id(rs.getString("c_id"));
			dto.setC_lv(rs.getInt("c_lv"));
			dto.setC_class(rs.getString("c_class"));
			
			dtoList.add(dto);
			
			
		}
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
		
		
	}
	
	
	@RequestMapping(value = "/order")
	public ModelAndView order(String selected) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView("dbtest");
		
		String id = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, id, password);
				
		//SQL작성
		String sql = "select * from char_info order by " + selected;
				
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
				
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		ResultSet rs = ps.executeQuery();
				
		List<CharInfoDto> dtoList = new ArrayList<CharInfoDto>();
				
		//결과값이 들어있는 ResultSet객체로 부터 데이터 빼내기
		//next()메소드
		//ResultSet 객체가 있으면 true 없으면 false를 반환
		
		while(rs.next()) {
			
			CharInfoDto dto = new CharInfoDto();
			dto.setC_id(rs.getString("c_id"));
			dto.setC_lv(rs.getInt("c_lv"));
			dto.setC_class(rs.getString("c_class"));
			
			dtoList.add(dto);
			
			
		}
		
		mv.addObject("dtoList", dtoList);
		
		return mv;
		
		
	}
	
	
	@RequestMapping(value = "/movefileupload")
	public ModelAndView movefileupload() throws SQLException, ClassNotFoundException {
		
		ModelAndView mv = new ModelAndView("filecontrol");
		
		String id = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
				
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, id, password);
		
		String sql = "select * from file";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<FileDto> dtoList = new ArrayList<FileDto>();
		
		while(rs.next()) {
			
			FileDto dto = new FileDto();
			//dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setWritter(rs.getString("writter"));
			dto.setFilename(rs.getString("filename"));
			dto.setFilesize(rs.getLong("filesize"));
			dto.setFilepath(rs.getString("filepath"));
			dto.setReg_date(rs.getString("reg_date"));
			
			dtoList.add(dto);
				
		}
		
		mv.addObject("dtoList", dtoList);
		
		
		
		return mv;
		
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest mhsr, String title, String writter) throws UnsupportedEncodingException {
		
		
		ModelAndView mv = new ModelAndView("filecontrol");
		
		String filePath = "D:\\filetest\\";
		
		MultipartFile file = mhsr.getFile("upfile");
		
		String filename = new String(file.getOriginalFilename().getBytes("8859_1"), "UTF-8");
		
		long filesize = file.getSize();
		
		try {
			
			file.transferTo(new File(filePath + filename));
			
			String id = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/test";
			
			//DB 종류
			Class.forName("com.mysql.jdbc.Driver");
					
			//DB에 접속하기(url, id, password)
			//mysql -u root
			Connection conn = DriverManager.getConnection(url, id, password);
					
			//SQL작성
			String sql = "insert into file(title, writter, filename, filesize, filepath) values(?, ?, ?, ?, ?) ";
			
			
			//SQL문을 DB에 전송하기(1/2)
			PreparedStatement ps = conn.prepareStatement(sql);
						
			
			ps.setString(1, title);
			ps.setString(2, writter);
			ps.setString(3, filename);
			ps.setLong(4, filesize);
			ps.setString(5, filePath);
			
			ps.executeUpdate();
			String sql2 = "select * from file";
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			
			ResultSet rs = ps2.executeQuery();
			
			List<FileDto> dtoList = new ArrayList<FileDto>();
			
			while(rs.next()) {
				
				FileDto dto = new FileDto();
				//dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWritter(rs.getString("writter"));
				dto.setFilename(rs.getString("filename"));
				dto.setFilesize(rs.getLong("filesize"));
				dto.setFilepath(rs.getString("filepath"));
				dto.setReg_date(rs.getString("reg_date"));
				
				dtoList.add(dto);
					
			}
			
			mv.addObject("dtoList", dtoList);
			
		} catch (Exception e) {
			System.out.println("업로드 오류");
		}
		
				
		return mv;
	}
	
}


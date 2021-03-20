package com.kimschool.app;

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

import com.kimschool.app.entity.CharDetailDto;
import com.kimschool.app.entity.CharInfoDto;
import com.kimschool.app.entity.ResultVo;

@Controller
public class ResultController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);
	
	@RequestMapping(value = "/result")
	public ModelAndView result() {
		logger.info("Result log");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		
		mv.addObject("str", "String입니다.");
		mv.addObject("num", 10);
		mv.addObject("bool", true);
		
		int[] intarr = new int[3];
		intarr[0] = 10;
		intarr[1] = 20;
		intarr[2] = 30;
		
		mv.addObject("intarr", intarr);
		
		List<String> strlist = new ArrayList<String>();
		
		strlist.add("첫");
		strlist.add("둘");
		strlist.add("셋");
		
		mv.addObject("strlist", strlist);
		
		ResultVo bean = new ResultVo();
		
		bean.setNum(1);
		bean.setName("이이름");
		bean.setDead(true);
		
		mv.addObject("bean", bean);
		
		List<ResultVo> beanlist = new ArrayList<ResultVo>();
		
		ResultVo bean1 = new ResultVo();
		
		bean1.setNum(10);
		bean1.setName("김이름");
		bean1.setDead(true);
		
		
		ResultVo bean2 = new ResultVo();
		
		bean2.setNum(100);
		bean2.setName("박이름");
		bean2.setDead(false);
		
		ResultVo bean3 = new ResultVo();
		
		bean3.setNum(1000);
		bean3.setName("최이름");
		bean3.setDead(true);
		
		beanlist.add(bean1);
		beanlist.add(bean2);
		beanlist.add(bean3);
		
		mv.addObject("beanlist", beanlist);
		
		return mv;
	}
	
	@RequestMapping(value = "/resultdetail")
	public ModelAndView detailinto(String id) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView("resultdetail");
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
			
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
				
		//SQL작성
		String sql = "select * from char_detail where c_id = ?";
				
		//SQL문을 DB에 전송하기(1/3)
		PreparedStatement ps = conn.prepareStatement(sql);
			
		//SQL문에 파라메터 삽입(2/3)
		//1부터 시작하니 주의할것!!!
		ps.setString(1, id);
				
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입(3/3)
		ResultSet rs = ps.executeQuery();
		
		
		//취득 데이터 마지막으로 이동(1개의 레코드만 존재할 경우 또는 마지막 레코드만 취득할때 사용)
		rs.last();
		
		CharDetailDto dto = new CharDetailDto();
		
		dto.setNo(rs.getInt("no"));
		dto.setC_id(rs.getString("c_id"));
		dto.setGold(rs.getInt("gold"));
		dto.setHunting_count(rs.getInt("hunting_count"));
		dto.setReg_date(rs.getString("reg_date"));
		dto.setMod_date(rs.getString("mod_date"));
		
		
		mv.addObject("dto", dto);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/moveregcharinfo")
	public ModelAndView moveregcharinfo() {
		
		ModelAndView mv = new ModelAndView("regcharinfo");
		
		return mv;
		
		
	}
	
	
	@RequestMapping(value = "/regcharinfo")
	public ModelAndView regcharinfo(String c_id, int c_lv, String c_class, int hunting_count, int gold) throws SQLException, ClassNotFoundException {
					
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
		String sql1 = "insert into char_info values(?, ?, ?);";
		String sql2 = "insert into char_detail(c_id, gold, hunting_count) values(?, ?,?);";
				
		//SQL문을 DB에 전송하기(1/3)
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		//SQL문에 파라메터 삽입(2/3)		
		//1부터 시작하니 주의할것!!!				
		ps1.setString(1, c_id);
		ps1.setInt(2, c_lv);
		ps1.setString(3, c_class);
		
		ps2.setString(1, c_id);
		ps2.setInt(2, gold);
		ps2.setInt(3, hunting_count);
		
				
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입(3/3)		
		int result1 = ps1.executeUpdate();
		int result2 = ps2.executeUpdate();
		
		if(result1 > 0 && result2 > 0) {
			//둘다 등록 성공일 떄 커밋
			conn.commit();
			
		}
		else {
			//아닌경우 롤백
			conn.rollback();
		}
		
		ModelAndView mv = new ModelAndView("redirect:/db");
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/movemodcharinfo")
	public ModelAndView movemodcharinfo(String id) throws ClassNotFoundException, SQLException {
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
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
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("moddetail");
		
		mv.addObject("dto", dto);
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/modcharinfo")
	public ModelAndView modcharinfo(String c_id, int hunting_count, int gold) throws ClassNotFoundException, SQLException {
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
		//SQL작성
		String sql = "update char_detail set hunting_count = ?, gold = ?, mod_date = now() where c_id = ?";
		
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, hunting_count);
		ps.setInt(2, gold);
		ps.setString(3, c_id);
	
		
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		int rs = ps.executeUpdate(); //**sql를 파라매터로 넣어주지 말것!!!!!!!!!!
		
		
		ModelAndView mv = new ModelAndView("redirect://");
			
		
		return mv;
		
		
	}
	
	
	@RequestMapping(value = "/searchbyid")
	public ModelAndView searchbyid(String search) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result");
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
		//SQL작성
		String sql = "select * from char_info where c_id like ?";
		
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "%" + search + "%");
		
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
	
	@RequestMapping(value = "/searchbyclass")
	public ModelAndView searchbyclass(String search) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result");
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
		//SQL작성
		String sql = "select * from char_info where c_class like ?";
		
		//SQL문을 DB에 전송하기(1/2)
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, "%" + search + "%");
		
		//SQL문을 DB에 전송 후 결과값을 ResultSet에 삽입
		ResultSet rs = ps.executeQuery();
		
		List<CharInfoDto> dtoList = new ArrayList<CharInfoDto>();
		
		//결과값이 들어있는 ResultSet객체로 부터 데이터 빼내기
		//next()메소드
		//ResultSet 객체가 있으면 true 없으면 false를 반환
		while(rs.next())  {
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
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result");
		
		String uid = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/test";
		
		//DB 종류
		Class.forName("com.mysql.jdbc.Driver");
		
		//DB에 접속하기(url, id, password)
		//mysql -u root
		Connection conn = DriverManager.getConnection(url, uid, password);
		
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
	
	@RequestMapping(value = "/moveupload")
	public ModelAndView moveupload() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("filecontrol");
		
		
		return mv;
		
		
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest mhsr) throws UnsupportedEncodingException {
		
		
		//업로드 폴더 지정
		String filePath = "c:\\kimschoolfile\\";
		
		//파일꺼내기
		MultipartFile file = mhsr.getFile("upfile");
		
		//파일명 취득하기
		String filename = new String(file.getOriginalFilename().getBytes("8859_1"), "UTF-8");
		
		long filesize = file.getSize();
		
		//지정폴더로 파일 이동시키기
		try {
			file.transferTo(new File(filePath + filename));
			
			String uid = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/test";
			
			//DB 종류
			Class.forName("com.mysql.jdbc.Driver");
			
			//DB에 접속하기(url, id, password)
			//mysql -u root
			Connection conn = DriverManager.getConnection(url, uid, password);
			
			//SQL작성
			String sql = "insert into file (filename, filesize, filepath) values(?, ?, ?)";
			
			//SQL문을 DB에 전송하기(1/2)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, filename);
			ps.setLong(2, filesize);
			ps.setString(3, filePath);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("파일 업로드 오류");
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("filecontrol");
		
		
		return mv;
		
		
	}
	
	
	

}

package com.kimschool.review;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kimschool.review.entity.TestBoard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class HomeControllerTest {

	@Autowired
	HomeController homeController;
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		List<TestBoard> resultlist = homeController.test1();
		
		int count = resultlist.size();
		
		assertEquals(3, count);
	}
	
	
	@Test
	// 사전데이터1 : 0(:예비회원)
	// 예상결과 : 등록건수 1건
	// 화면에 권한 항목이「예비회원」으로 표시된다 
	public void test1() throws ClassNotFoundException, SQLException {
		
		homeController.removetable();
		
		homeController.insertboard("test1", "title1", 0, "content1", "0");
		
		List<TestBoard> resultlist = homeController.test1();
		
		int count = resultlist.size();
		
		assertEquals(1, count);
	}
	
	@Test
	// 사전데이터1 : 0(:예비회원)
	// 사전데이터2 : 1(:일반회원)
	// 예상결과 : 등록건수 2건
	// 화면에 권한 항목이 순서대로「예비회원」「일반회원」이 표시된다.	
	public void test2() throws ClassNotFoundException, SQLException {
		
		homeController.removetable();
		
		homeController.insertboard("test1", "title1", 0, "content1", "0");
		homeController.insertboard("test2", "title2", 0, "content2", "1");
		
		List<TestBoard> resultlist = homeController.test1();
		
		int count = resultlist.size();
		
		assertEquals(2, count);
	}
	
	@Test
	// 사전데이터1 : 0(:예비회원)
	// 사전데이터2 : 1(:일반회원)
	// 사전데이터3 : 2(:우등회원)
	// 사전데이터4 : 3(:관리자)
	// 사전데이터5 : 4(:KIMSCHOOL)
	// 예상결과 : 등록건수 5건
	// 화면에 권한 항목이 순서대로「예비회원」「일반회원」「우등회원」「관리자」「KIMSCHOOL」이 표시된다.	
	public void test3() throws ClassNotFoundException, SQLException {
		
		homeController.removetable();
		
		homeController.insertboard("test1", "title1", 0, "content1", "0");
		homeController.insertboard("test2", "title2", 0, "content2", "1");
		homeController.insertboard("test3", "title2", 0, "content3", "2");
		homeController.insertboard("test4", "title2", 0, "content4", "3");
		homeController.insertboard("test5", "title2", 0, "content5", "4");
		
		List<TestBoard> resultlist = homeController.test1();
		
		int count = resultlist.size();
		
		assertEquals(5, count);
	}

	@Test
	// 사전데이터1 : 6(:해당코드없음)
	// 예상결과 : 등록건수 1건
	// 화면에 권한 항목에 ""(공백)이 표시된다.
	public void test4() throws ClassNotFoundException, SQLException {
		
		homeController.removetable();
		
		homeController.insertboard("test1", "title1", 0, "content1", "6");
		
		List<TestBoard> resultlist = homeController.test1();
		
		int count = resultlist.size();
		
		assertEquals(1, count);
	}
 
}

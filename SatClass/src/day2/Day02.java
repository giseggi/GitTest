package day2;

import java.util.ArrayList;
import java.util.List;

public class Day02 {

	public static void main(String[] args) {
	
		
		List<TestBean> beanList = new ArrayList<TestBean>();
		
		TestBean testBean1 = new TestBean();
		
		testBean1.setUserID("STG0614");
		testBean1.setUserCompany("KIMSCHOOL");
		testBean1.setUserNumber(123);
		
		TestBean testBean2 = new TestBean();
		
		testBean2.setUserID("STG0615");
		testBean2.setUserCompany("LEESCHOOL");
		testBean2.setUserNumber(456);
		
		TestBean testBean3 = new TestBean();
		
		testBean3.setUserID("STG0616");
		testBean3.setUserCompany("PARKSCHOOL");
		testBean3.setUserNumber(789);
			
		
		TestBean testBean4 = new TestBean();
		
		testBean4.setUserID("KOREA");
		testBean4.setUserCompany("PARKSCHOOL");
		testBean4.setUserNumber(123); 
		
		
		beanList.add(testBean1);
		beanList.add(testBean2);
		beanList.add(testBean3);
		beanList.add(testBean4);
		
		
		
		
		for(TestBean bean : beanList) {
			
			if(bean.getUserID().contains("KOR")) {
			
				System.out.println(bean.getUserID());
				System.out.println(bean.getUserCompany());
				System.out.println(bean.getUserNumber());
				System.out.println("---------");
			}
		}
		
	}
}

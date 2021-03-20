package com.study.mybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.mybatis.dto.UserInfoDto;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SqlSessionTemplate sqlsession;
	
	@Override
	public String function(UserInfoDto dto) {
		
//		String result = sqlsession.selectOne("UserInfo.selectId", dto);
		
		int result = sqlsession.update("UserInfo.updateIdAndPassword", dto);
		
		return "test";
	}

}

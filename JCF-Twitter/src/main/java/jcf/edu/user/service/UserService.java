package jcf.edu.user.service;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private QueryExecutor dao;

	public List<UserVO> getAllUser(Map param){

		return dao.queryForList("user.find", param, UserVO.class);
	}

	public void insertUser (UserVO user){
		dao.update("user.insert", user);
	}

	public UserVO findUser (Map param){
		System.out.println("TEST________1111111"+param);
		return dao.queryForObject("user.find", param, UserVO.class);
	}


}

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
	
	public List<UserVO> findCustomer(Map<String, String> map) {
		
		return dao.queryForList("user.find",map,UserVO.class);
		
	}
	
	public List<UserVO> findCustomer2(UserVO userVO) {
		
		return dao.queryForList("user.find2",userVO,UserVO.class);
		
	}
	
	public void insertUser(UserVO user) {
		dao.update("user.insert", user);
	}
	public void deleteUser(UserVO user) {
		dao.update("user.delete", user);
	}
	public void updateUser(UserVO user) {
		dao.update("user.update", user);
	}

}

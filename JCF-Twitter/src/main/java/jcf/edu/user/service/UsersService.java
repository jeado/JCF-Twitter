package jcf.edu.user.service;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	@Autowired
	private QueryExecutor dao;

	public List<UserVO> getAllProduct(){
		//return dao.queryForList(CustomerQuery.selectAll, null, Customer.class);
		return dao.queryForList("users.select", null, UserVO.class);
	}
	public List<UserVO> findUsers(Map<String, String> map){
		return dao.queryForList("users.find", map, UserVO.class);
	}
	public void insertUsers(UserVO user){
		dao.update("users.insert", user);
	}
	public void updateUsers(UserVO user){
		dao.update("users.update", user);
	}
	public void deleteUsers(UserVO user){
		dao.update("users.delete", user);
	}
}

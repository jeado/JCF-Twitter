package jcf.edu.user.service;

import java.util.List;
import java.util.Map;

import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcf.edu.user.model.UserVO;

@Service
public class UserService {

	@Autowired
	private QueryExecutor excutor;

	public List<UserVO> getAllUser(){
		return excutor.queryForList("user.select", null, UserVO.class);
//		return excutor.queryForList(CustomerQuery.selectAll, null, Customer.class);
	}

	public List<UserVO> findUser(Map<String, String> map) {
		return excutor.queryForList("user.find", map, UserVO.class);
	}

	public void insertUser(UserVO uservo){
		excutor.update("user.insert", uservo);
		 // excutor.update(CustomerQuery.insertAt, customer);
	}

	public void updateUser(UserVO uservo){
		excutor.update("user.update", uservo);
		 // excutor.update(CustomerQuery.updateAt, customer);
	}

	public void deleteUser(UserVO uservo){
		excutor.update("user.delete", uservo);
	 // excutor.update(CustomerQuery.deleteat, customer);
	 }

}

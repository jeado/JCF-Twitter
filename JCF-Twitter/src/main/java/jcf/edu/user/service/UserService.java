package jcf.edu.user.service;

import java.util.List;
import java.util.Map;

import jcf.edu.pic.model.PicVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private QueryExecutor dao;

	public List<UserVO> getUser(Map param){

		return dao.queryForList("user.find", param, UserVO.class);
	}

	public void insertUser (UserVO user){
		dao.update("user.insert", user);
	}

	public void insertPhoto (PicVO pic){
		dao.update("pic.insert", pic);
	}

	public UserVO findUser (Map param){
		return dao.queryForObject("user.find", param, UserVO.class);
	}

	public void deleteUser (UserVO user){
		dao.update("user.delete", user);
	}

	public void updateUser (UserVO user){
		dao.update("user.update", user);
	}

}

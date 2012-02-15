package jcf.edu.user.service;

import java.util.List;
import java.util.Map;

import jcf.edu.manage.model.TweetVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private QueryExecutor dao;
	
	public List<UserVO> getAllUser() {
		return dao.queryForList("user.select", null, UserVO.class);
	}
	
	public List<UserVO> getSomeUser(UserVO user) {
		return dao.queryForList("user.select2", user, UserVO.class);
	}
	
	
//	public List<UserVO> findUser(Map<String, String> map){		
//		return dao.queryForList("user.find", map, UserVO.class);		
//	}
	
	
	public List<UserVO> findUser2(UserVO user){		
		return dao.queryForList("user.find2", user, UserVO.class);		
	}
	
	public void insertUser(UserVO user) {
		dao.update("user.insert", user);
	}

	public void updateUser(UserVO user) {
		dao.update("user.update", user);
	}

	public void deleteUser(UserVO user) {
		dao.update("user.delete", user);
	}
	
	
	

}

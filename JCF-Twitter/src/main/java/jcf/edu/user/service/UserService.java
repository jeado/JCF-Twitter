package jcf.edu.user.service;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.PicVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private QueryExecutor executor;

	public List<UserVO> findUsers(UserVO user){
		return executor.queryForList("user.select", user, UserVO.class);
	}

	public List<UserVO> loginUser(UserVO user){
		return executor.queryForList("user.login", user, UserVO.class);
	}

	public void deleteUser(UserVO user){
		executor.update("user.delete", user);
	}

	public void updateUser(UserVO user){
		executor.update("user.update", user);
	}

	public void insertUser(Map<String,String> user){
		executor.update("user.insert", user);
	}

	public void insertPic(PicVO picVO){
		executor.update("user.insertPic", picVO);
	}

	public List<PicVO> selectPic(PicVO picVO){
		return executor.queryForList("user.selectPic", picVO, PicVO.class);
	}

	public void updatePic(PicVO picVO){
		executor.update("user.updatePic", picVO);
	}

}

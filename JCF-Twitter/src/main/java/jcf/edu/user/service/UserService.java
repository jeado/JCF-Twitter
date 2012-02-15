package jcf.edu.user.service;

import java.util.List;

import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private QueryExecutor dao;

	//유저출력
	public List<UserVO> getUser(UserVO userVO) {
		return dao.queryForList("TwitterUser.select", userVO, UserVO.class);
	}
	//유저리스트
	public List<UserVO> getUserList(UserVO userVO) {
		return dao.queryForList("TwitterUser.userselect", userVO, UserVO.class);
	}
	//유저입력
	public void insertUser(UserVO userVO) {
		dao.update("TwitterUser.insert", userVO);
	}
	//유저수정
	public void updateUser(UserVO userVO) {
		dao.update("TwitterUser.update", userVO);
	}
	//유저삭제
	public void deleteUser(UserVO userVO) {
		dao.update("TwitterUser.delete", userVO);
	}
 
}

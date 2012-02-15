package jcf.edu.service;

import java.util.List;

import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicService {
	@Autowired
	private QueryExecutor dao;

	public List<UserVO> getAllUser() {

		return dao.queryForList("TwitterUserPic.xml.select", null, UserVO.class);

	}
	public void insertUser(UserVO Pic) {
		dao.update("TwitterUserPic.xml.insert", Pic);
	}
	public void updateUser(UserVO Pic) {
		dao.update("TwitterUserPic.xml.update", Pic);
	}
	public void deleteUser(UserVO Pic) {
		dao.update("TwitterUserPic.xml.delete", Pic);
	}
}

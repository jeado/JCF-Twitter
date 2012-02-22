package jcf.edu.follow.service;

import java.util.List;
import java.util.Map;

import jcf.edu.follow.model.FollowVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FollowService {

	@Autowired
	private QueryExecutor dao;

	public List<FollowVO> getAllProduct(){

		return dao.queryForList("follow.select", null, FollowVO.class);
	}
	public void insertFollow(FollowVO follow){
		dao.update("follow.insert", follow);
	}
	public void deleteFollow(FollowVO follow){
		dao.update("follow.delete", follow);
	}
	public List<FollowVO> followUsers(Map<String, String> map){
		return dao.queryForList("follow.select", map, FollowVO.class);
	}
}

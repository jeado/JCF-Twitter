package jcf.edu.user.service;



import java.util.List;
import java.util.Map;

import jcf.edu.user.model.FollowingVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
	@Autowired
	private QueryExecutor dao;
	
	public void following(FollowingVO followingVO) {
		dao.update("following.insert",followingVO);
	}
	public void unfollowing(FollowingVO followingVO) {
		dao.update("following.delete", followingVO);
	}
	
	public List<FollowingVO> findcustomer(FollowingVO f) {
		
		return dao.queryForList("following.find",f,FollowingVO.class);
		
	} 

}

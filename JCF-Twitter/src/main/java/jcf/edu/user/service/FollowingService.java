package jcf.edu.user.service;

import java.util.List;
import java.util.Map;
import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
	@Autowired
	private QueryExecutor dao;
	
	

	public List<FollowingVO> getAllFollower() {
		return dao.queryForList("following.select", null, FollowingVO.class);
	}
	
	public List<FollowingVO> findUser(FollowingVO follower){		
		return dao.queryForList("following.find", follower, FollowingVO.class);		
	}
	
	
	
	public void insertFollowing(FollowingVO following) {
		dao.update("following.insert", following);
	}

	public void updateCustomer(FollowingVO following) {
		dao.update("following.update", following);
	}

	public void deleteCustomer(FollowingVO following) {
		dao.update("following.delete", following);
	}
}

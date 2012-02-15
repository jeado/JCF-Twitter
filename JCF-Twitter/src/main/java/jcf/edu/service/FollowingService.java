package jcf.edu.service;

import java.util.List;

import jcf.edu.model.TwitterUserFollowing;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
	@Autowired
	private QueryExecutor dao;

	public List<TwitterUserFollowing> getAllFollowing(UserVO userVO) {
		return dao.queryForList("TwitterUserFollowing.select", userVO, TwitterUserFollowing.class);
	}
	
	public void insertFollowing(TwitterUserFollowing following) {
		dao.update("TwitterUserFollowing.insert", following);
	}
	public void updateFollowing(TwitterUserFollowing following) {
		dao.update("TwitterUserFollowing.update", following);
	}
	public void deleteFollowing(TwitterUserFollowing following) {
		dao.update("TwitterUserFollowing.delete", following);
	}
}

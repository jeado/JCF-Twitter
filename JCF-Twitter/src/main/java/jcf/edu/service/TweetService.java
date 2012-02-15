package jcf.edu.service;

import java.util.List;

import jcf.edu.model.TwitterTweet;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
	@Autowired
	private QueryExecutor dao;

	public List<TwitterTweet> getAllTweet() {
		return dao.queryForList("TwitterTweet.select", null, TwitterTweet.class);
	}
	
	public List<TwitterTweet> getFollowingTweet(UserVO userVO) {
		return dao.queryForList("TwitterTweet.followingselect", userVO, TwitterTweet.class);
	}
	
	public void insertTweet(TwitterTweet tweet) {
		dao.update("TwitterTweet.insert", tweet);
	}
	public void updateTweet(TwitterTweet tweet) {
		dao.update("TwitterTweet.update", tweet);
	}
	public void deleteTweet(TwitterTweet tweet) {
		dao.update("TwitterTweet.delete", tweet);
	}
}
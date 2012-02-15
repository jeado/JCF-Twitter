package jcf.edu.manage.service;

import java.util.List;

import jcf.edu.manage.model.TweetVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
	
	@Autowired
	private QueryExecutor dao;
	
	public List<TweetVO> getAllTweet() {
		return dao.queryForList("tweet.select", null, TweetVO.class);
	}
	
	public List<TweetVO> getBoard(TweetVO tweet) {
		return dao.queryForList("tweet.board", tweet, TweetVO.class);
	}
	
	public List<TweetVO> getBoard2(UserVO tweet) {
		return dao.queryForList("tweet.board2", tweet, TweetVO.class);
	}
	
	
	public void insertTweet(TweetVO tweet) {
		dao.update("tweet.insert", tweet);
	}

	public void updateTweet(TweetVO tweet) {
		dao.update("tweet.update", tweet);
	}

	public void deleteTweet(TweetVO tweet) {
		dao.update("tweet.delete", tweet);
	}
}

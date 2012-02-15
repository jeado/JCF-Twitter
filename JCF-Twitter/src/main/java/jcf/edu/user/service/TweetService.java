package jcf.edu.user.service;


import java.util.List;
import java.util.Map;

import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.model.TweetVO;


import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

	@Autowired
	private QueryExecutor dao;
	
	public void insertTweet(TweetVO tweetVO) {
		dao.update("tweet.insert", tweetVO);		
	}
	public List<TweetVO> selectTweet(FollowingVO f) {
		
		return dao.queryForList("tweet.find",f,TweetVO.class);
		
	}
	public void deleteTweet(TweetVO tweetVO) {
		dao.update("tweet.delete",tweetVO);
	}
	

}

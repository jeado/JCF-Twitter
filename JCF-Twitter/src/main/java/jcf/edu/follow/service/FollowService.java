package jcf.edu.follow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcf.edu.follow.model.FollowVO;
import jcf.edu.tweet.model.TweetVO;
import jcf.query.core.QueryExecutor;

@Service
public class FollowService {

	@Autowired
	private QueryExecutor dao;

	public void insertFollow(FollowVO follow) {
		dao.update("follow.insert", follow);
	}

	public List<FollowVO> getFollows(FollowVO follow) {
		return dao.queryForList("follow.find", follow, FollowVO.class);
	}

}

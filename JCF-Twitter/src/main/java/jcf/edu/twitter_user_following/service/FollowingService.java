package jcf.edu.twitter_user_following.service;

import java.util.List;
import java.util.Map;

import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcf.edu.twitter_user_following.model.FollowingVO;

@Service
public class FollowingService {

	@Autowired
	private QueryExecutor excutor;

	public List<FollowingVO> getAllFollower(){
		return excutor.queryForList("twitter_user_following.select", null, FollowingVO.class);
	}

	public List<FollowingVO> findFollower(Map<String, String> map) {
		return excutor.queryForList("twitter_user_following.find", map, FollowingVO.class);
	}

	public void insertFollower(FollowingVO followingvo){
		excutor.update("twitter_user_following.insert", followingvo);
	}

	public void updateFollower(FollowingVO followingvo){
		excutor.update("twitter_user_following.update", followingvo);
	}

	public void deleteFollower(FollowingVO followingvo){
		excutor.update("twitter_user_following.delete", followingvo);
	 }

}

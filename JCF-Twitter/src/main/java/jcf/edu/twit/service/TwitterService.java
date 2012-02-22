package jcf.edu.twit.service;

import java.util.List;
import java.util.Map;

import jcf.edu.twit.model.TwitVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TwitterService {

	@Autowired
	private QueryExecutor dao;


	public List<TwitVO> getAllProduct(){
		//return dao.queryForList(CustomerQuery.selectAll, null, Customer.class);
		return dao.queryForList("twit.find", null, TwitVO.class);
	}
	public List<TwitVO> tweetList(UserVO userVO){
		return dao.queryForList("twit.followfind",userVO, TwitVO.class);
	}

	public List<UserVO> findUsers(Map<String, String> map){
		return dao.queryForList("users.find", map, UserVO.class);
	}

	public void insertTwit(TwitVO twit){
		dao.update("twit.insert", twit);
	}
}

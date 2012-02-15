package jcf.edu.service;

import java.util.List;

import jcf.edu.model.TwitterUserPic;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicService {
	@Autowired
	private QueryExecutor dao;

	public List<TwitterUserPic> getpic(TwitterUserPic picVO) {
		return dao.queryForList("TwitterUserPic.select", picVO, TwitterUserPic.class);
	}
	
	public void insertpic(TwitterUserPic Pic) {
		dao.update("TwitterUserPic.insert", Pic);
	}
	public void updatepic(TwitterUserPic Pic) {
		dao.update("TwitterUserPic.update", Pic);
	}
	public void deletepic(TwitterUserPic Pic) {
		dao.update("TwitterUserPic.delete", Pic);
	}
}

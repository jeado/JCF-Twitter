package jcf.edu.twitter_user_pic.service;

import java.util.List;
import java.util.Map;

import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcf.edu.twitter_user_pic.model.PicVO;

@Service
public class PicService {

	@Autowired
	private QueryExecutor excutor;

	public List<PicVO> getAllPic(){
		return excutor.queryForList("twitter_user_following.select", null, PicVO.class);
	}

	public List<PicVO> findPic(Map<String, String> map) {
		return excutor.queryForList("twitter_user_following.find", map, PicVO.class);
	}

	public void insertPic(PicVO picvo){
		excutor.update("twitter_user_following.insert", picvo);
	}

	public void updatePic(PicVO picvo){
		excutor.update("twitter_user_following.update", picvo);
	}

	public void deletePic(PicVO picvo){
		excutor.update("twitter_user_following.delete", picvo);
	 }

}

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
		return excutor.queryForList("pic.select", null, PicVO.class);
	}

	public List<PicVO> findPicList(Map<String, String> map) {
		return excutor.queryForList("pic.find", map, PicVO.class);
	}

	public List<PicVO> findPic(PicVO picvo){
	    return excutor.queryForList("pic.findpic", picvo, PicVO.class);
	}

	public void insertPic(PicVO picvo){
		excutor.update("pic.insert", picvo);
	}

	public void updatePic(PicVO picvo){
		excutor.update("pic.update", picvo);
	}

	public void deletePic(PicVO picvo){
		excutor.update("pic.delete", picvo);
	}

}

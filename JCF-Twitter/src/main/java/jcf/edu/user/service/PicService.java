package jcf.edu.user.service;


import java.util.List;
import java.util.Map;

import jcf.edu.user.model.PicVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicService {
	@Autowired
	private QueryExecutor dao;
	
	public void insertPic(PicVO pic) {
		dao.update("pic.insert", pic);
	}
	
	public List<PicVO> findPicture(PicVO p) {
		
		return dao.queryForList("pic.find",p,PicVO.class);
		
	}
	public void updatePic(PicVO pic) {
		dao.update("pic.update", pic);
	}
}

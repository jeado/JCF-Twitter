package jcf.edu.user.service;

import java.util.List;

import jcf.edu.user.model.PicVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PicService {
	
	@Autowired
	private QueryExecutor dao;
	
	public List<PicVO> getAllPic(PicVO pic) {
		return dao.queryForList("pic.select", pic, PicVO.class);
	} 
	public void insertPic(PicVO pic) {
		dao.update("pic.insert", pic);
	}

	public void updatePic(PicVO pic) {
		dao.update("pic.update", pic);
	}

	public void deletePic(PicVO pic) {
		dao.update("pic.delete", pic);
	}

}

package jcf.edu.pic.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcf.edu.pic.model.PicVO;
import jcf.query.core.QueryExecutor;

@Service
public class PicService {

	@Autowired
	private QueryExecutor dao;
	public PicVO findPic(PicVO pic) {
		return dao.queryForObject ("pic.find", pic, PicVO.class);

	}

	public void insertPhoto(PicVO pic) {
		dao.update("pic.insert", pic);

	}

}

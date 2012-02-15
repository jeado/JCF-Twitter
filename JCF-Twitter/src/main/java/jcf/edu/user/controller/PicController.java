package jcf.edu.user.controller;

import java.util.List;

import jcf.edu.user.model.PicVO;
import jcf.edu.user.service.PicService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;
import jcf.upload.FileInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PicController {
	
	@Autowired
	private PicService picService;
	
	@RequestMapping ("/file/fileView/{userId}")
	public void picView (MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
	
		PicVO pic = new PicVO();
		pic.setUserId(userId);
		List<PicVO> select = picService.getAllPic(pic);
		System.out.println(userId);
		
		if(!select.isEmpty()){
			mciResponse.setDownloadFile(new FileInfo(select.get(0).getFilePath(),select.get(0).getFileUuid()));
		}		
	 }
}
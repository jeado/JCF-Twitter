package jcf.edu.pic.controller;

import java.util.HashMap;
import java.util.Map;

import jcf.edu.pic.model.PicVO;
import jcf.edu.pic.service.PicService;
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
	PicService picService;

	//-------------------------------------사진 --------------------------------------
		@RequestMapping ("/file/fileView/{userId}")
		public void picView (MciRequest mciRequest, MciResponse mciResponse,
								@PathVariable String userId){
			PicVO pic = new PicVO();
			pic.setUserId(userId);
			PicVO fpic = picService.findPic(pic);
			mciResponse.setDownloadFile(new FileInfo(fpic.getFilePath(), fpic.getFileUuid()));

		}
}
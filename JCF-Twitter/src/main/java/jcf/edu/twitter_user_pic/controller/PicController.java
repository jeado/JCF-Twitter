package jcf.edu.twitter_user_pic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.twitter_user_pic.service.PicService;
import jcf.edu.twitter_user_pic.model.PicVO;
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

	@RequestMapping("file/viewFile/{userId}")
	public void viewFile(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
		Map map = new HashMap();
		map.put("userId", userId);
		List<PicVO> pic = picService.findPic(map);

		String fileName = pic.get(0).getFileName();
		String filePath = pic.get(0).getFilePath();

		mciResponse.setDownloadFile(new FileInfo(filePath, fileName));
		System.out.println("<viewFile>fileName :" + fileName + "filePath :" + filePath);
	}
}

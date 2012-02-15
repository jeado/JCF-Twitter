package jcf.edu.twitter_user_pic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.twitter_user_pic.service.PicService;
import jcf.edu.twitter_user_pic.model.PicVO;
import jcf.edu.user.service.UserService;
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

	@Autowired
	private UserService userService;

	@RequestMapping("file/fileView/{userId}")
	public void viewFile(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
		System.out.println("file/viewFile/{userId}실행");
		Map map = new HashMap();
		map.put("userId", userId);
		List<PicVO> pic = picService.findPicList(map);

		String fileUuid = pic.get(0).getFileUuid();
		String filePath = pic.get(0).getFilePath();

		System.out.println("<fileView>fileUuid : " + fileUuid + " filePath : " + filePath);

		mciResponse.setDownloadFile(new FileInfo(filePath, fileUuid));
	}
}

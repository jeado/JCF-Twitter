package jcf.edu.user.controller;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping("/file/fileView/{userId}")
	public void picView(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId) {
		PicVO tmp = new PicVO();
		tmp.setUserId(userId);
		
		List<PicVO> findCustomer = picService.findPicture(tmp);
		PicVO p = findCustomer.get(0);
		
		mciResponse.setDownloadFile(new FileInfo(p.getFilePath(),p.getFileUuid()));
		
		
	}
	
	


}

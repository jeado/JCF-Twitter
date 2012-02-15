package jcf.edu.user.fileHandler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;


import jcf.edu.user.model.PicVO;
import jcf.edu.user.service.PicService;
import jcf.upload.FileInfo;
import jcf.upload.MultiPartInfo;
import jcf.upload.handler.UploadEventHandler;
import jcf.upload.persistence.PersistenceManager;

public class UserPicUploadEventHandler implements UploadEventHandler {

	@Autowired
	private PicService picService;
	
	public long getMaxUploadSize() {
		return 10000000;
	}

	public String getFolder(HttpServletRequest request) {
		return "userpic";
	}

	public void postprocess(String folder, MultiPartInfo info,
			PersistenceManager persistenceManager) {

		String userId = (String)info.getAttributes().get("userId");
		List<FileInfo> fileInfos = info.getFileInfos();
		
		FileInfo fileInfo = fileInfos.get(0);
		String fileUuid = fileInfo.getCallName();
		String fileName = fileInfo.getName();
		String filePath = fileInfo.getFolder();
	
		PicVO pic = new PicVO();
		pic.setFileUuid(fileUuid);
		pic.setFileName(fileName);
		pic.setFilePath(filePath);
		pic.setUserId(userId);
		
				
		List<PicVO> picList = picService.findPicture(pic);
		
		if(picList.isEmpty()) {
			picService.insertPic(pic);
		}
		else {
			picService.updatePic(pic);
		}

	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		
		return UUID.randomUUID().toString();
	}

	public void prepareStorage(PersistenceManager persistenceManager,
			String folder) {
	}

}

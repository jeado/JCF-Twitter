package jcf.edu.user.fileHandler;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import jcf.edu.user.model.PicVO;
import jcf.edu.user.service.UserService;
import jcf.upload.FileInfo;
import jcf.upload.MultiPartInfo;
import jcf.upload.handler.UploadEventHandler;
import jcf.upload.persistence.PersistenceManager;

import org.springframework.beans.factory.annotation.Autowired;

public class UserPicUploadEventHandler implements UploadEventHandler {

	@Autowired
	private UserService userService;

	public long getMaxUploadSize() {
		return 10000000;
	}

	public String getFolder(HttpServletRequest request) {
		return "userpic";
	}

	public void postprocess(String folder, MultiPartInfo info,
			PersistenceManager persistenceManager) {
		Map<String, Object> attributes = info.getAttributes();
		String userId = (String)attributes.get("userId");
		List<FileInfo> fileInfos = info.getFileInfos();
		FileInfo fileInfo = fileInfos.get(0);
		
		String fileUuid = fileInfo.getCallName();
		String fileName = fileInfo.getName();
		String filePath = fileInfo.getFolder();

		PicVO picVO = new PicVO(fileUuid,fileName,filePath,userId);
		List<PicVO> selectPic = userService.selectPic(picVO);
		if(selectPic.isEmpty())
			userService.insertPic(picVO);
		else
			userService.updatePic(picVO);
	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		return UUID.randomUUID().toString()+".jpg";
	}

	public void prepareStorage(PersistenceManager persistenceManager,
			String folder) {
	}
}

package jcf.edu.user.fileHandler;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.twitter_user_pic.model.PicVO;
import jcf.edu.twitter_user_pic.service.PicService;
import jcf.upload.FileInfo;
import jcf.upload.MultiPartInfo;
import jcf.upload.handler.UploadEventHandler;
import jcf.upload.persistence.PersistenceManager;



public class UserPicUploadEventHandler implements UploadEventHandler {

	@Autowired
	private PicService picService;

	public long getMaxUploadSize() {
		return  5* 1024 * 1024; //5Mb
	}

	public String getFolder(HttpServletRequest request) {
		return "userpic";
	}

	public void postprocess(String folder, MultiPartInfo info, PersistenceManager persistenceManager) {
//		Map<String, Object> attributes = info.getAttributes();
//		String userFile = (String)attributes.get("userFile");

		List<FileInfo> fileInfos = info.getFileInfos();
		FileInfo fileInfo = fileInfos.get(0);//end

		String callName = fileInfo.getCallName();//start1 긴거(DB에 저장)
		String fileName = fileInfo.getName();//start2 실제
		String userfolder = fileInfo.getFolder();
		String crntUserId = SessionUtil.getCurrentUser().getUserId();

//		System.out.println("<postprocess> PID: " + pid + " CallName: " + callName + " name: " + name);

		PicVO picvo = new PicVO(callName, fileName, userfolder, crntUserId);

		picService.insertPic(picvo);
	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		return UUID.randomUUID().toString();
	}

	public void prepareStorage(PersistenceManager persistenceManager, String folder) {
	}

}

package jcf.edu.user.fileHandler;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jcf.edu.user.model.UserVO;
import jcf.upload.FileInfo;
import jcf.upload.MultiPartInfo;
import jcf.upload.handler.UploadEventHandler;
import jcf.upload.persistence.PersistenceManager;

public class UserPicUploadEventHandler implements UploadEventHandler {

	public long getMaxUploadSize() {
		return 10000000;
	}

	public String getFolder(HttpServletRequest request) {
		return "userpic";
	}

	public void postprocess(String folder, MultiPartInfo info, PersistenceManager persistenceManager) {
		Map<String, Object> attributes = info.getAttributes();
		String pid = (String)attributes.get("pid");

		List<FileInfo> fileInfos = info.getFileInfos();
		FileInfo fileInfo = fileInfos.get(0);//end

		String callName = fileInfo.getCallName();//start1
		String name = fileInfo.getName();//start2

		System.out.println("<postprocess> PID: " + pid + " CallName: " + callName + " name: " + name);
		UserVO uservo = null;

//		productService.insertProduct(product);
	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		return fileInfo.getFieldName();
	}

	public void prepareStorage(PersistenceManager persistenceManager, String folder) {
	}

}

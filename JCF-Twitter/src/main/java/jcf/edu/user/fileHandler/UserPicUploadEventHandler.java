package jcf.edu.user.fileHandler;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

	public void postprocess(String folder, MultiPartInfo info,
			PersistenceManager persistenceManager) {
		Map<String, Object> attribute = info.getAttributes();
		String pid = (String) attribute.get("pid");

		List<FileInfo> fileInfos = info.getFileInfos();
		FileInfo fileInfo = fileInfos.get(0);
		String callName = fileInfo.getCallName();
		String name = fileInfo.getName();

		System.out.println("PID = "+pid);
		System.out.println("Original Name : "+name);
		System.out.println("CallName : "+callName);

	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		return fileInfo.getFieldName();
	}

	public void prepareStorage(PersistenceManager persistenceManager,
			String folder) {
	}

}

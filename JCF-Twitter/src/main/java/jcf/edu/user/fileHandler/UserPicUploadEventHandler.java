package jcf.edu.user.fileHandler;


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

	public void postprocess(String folder, MultiPartInfo info, PersistenceManager persistenceManager) {
	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		return fileInfo.getFieldName();
	}

	public void prepareStorage(PersistenceManager persistenceManager, String folder) {
	}

}

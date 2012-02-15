package jcf.edu.user.fileHandler;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import jcf.edu.pic.model.PicVO;
import jcf.edu.pic.service.PicService;
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

		Map<String, Object> attributes = info.getAttributes();

		// 모든 parameter 출력해보기
		String userId = (String) attributes.get("userId");
		String userName = (String) attributes.get("userName");
		String userFile = (String) attributes.get("userFile");
		System.out.println("---------------------파라미터 테스트---------------------");
		System.out.println("User_id  :  "+userId+"User_name  :  "+userName+"User_file  :  "+userFile);


		List<FileInfo> fileInfos = info.getFileInfos();
		FileInfo fileInfo = fileInfos.get(0);

		//상위에 지정해 놓은 난수값을 받아올수 있다.
		String callName = fileInfo.getCallName();
		String name = fileInfo.getName();

		System.out.println("---------------------파일 테스트---------------------");
		System.out.println("Original Name: "+name+" .CallName: "+callName);

		PicVO pic = new PicVO();
		pic.setFileName(name);
		pic.setFileUuid(callName);
		pic.setFilePath("userpic");
		pic.setUserId(userId);

		if((picService.selectPhoto(pic))==null)
		{
			picService.insertPhoto(pic);
		}else{
			picService.updatePhoto(pic);
		}

	}

	public String createFileNameIfAccepted(String folder, FileInfo fileInfo) {
		//난수를 발생시켜서 중복되는 파일값이 없도록 한다.
		//return UUID.randomUUID().toString();

		return UUID.randomUUID().toString();
	}

	public void prepareStorage(PersistenceManager persistenceManager,
			String folder) {

	}

}

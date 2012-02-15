package jcf.edu.twitter_user_pic.model;

public class PicVO {

	private String fileUuid;
	private String fileName;
	private String filePath;
	private String userId;

	public PicVO(String fileUuid, String fileName, String filePath,	String userId) {
		super();
		this.fileUuid = fileUuid;
		this.fileName = fileName;
		this.filePath = filePath;
		this.userId = userId;
	}


	public PicVO() {
	}

	public String getFileUuid() {
		return fileUuid;
	}


	public void setFileUuid(String fileUuid) {
		this.fileUuid = fileUuid;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

}

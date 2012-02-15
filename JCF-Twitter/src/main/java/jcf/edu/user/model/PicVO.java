package jcf.edu.user.model;

public class PicVO {

	private String fileUuid;
	private String fileName;
	private String filePath;
	private String userId;

	public PicVO() {
		super();
	}
	public PicVO(String fileUuid, String fileName, String filePath,
			String userId) {
		super();
		this.fileUuid = fileUuid;
		this.fileName = fileName;
		this.filePath = filePath;
		this.userId = userId;
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

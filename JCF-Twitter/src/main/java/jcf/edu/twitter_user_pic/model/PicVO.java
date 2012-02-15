package jcf.edu.twitter_user_pic.model;

public class PicVO {

	private String file_uuid;
	private String file_name;
	private String file_path;
	private String user_id;

	public String getFile_uuid() {
		return file_uuid;
	}
	public void setFile_uuid(String file_uuid) {
		this.file_uuid = file_uuid;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public PicVO(String file_uuid, String file_name, String file_path,
			String user_id) {
		super();
		this.file_uuid = file_uuid;
		this.file_name = file_name;
		this.file_path = file_path;
		this.user_id = user_id;
	}

	public PicVO() {
	}
}

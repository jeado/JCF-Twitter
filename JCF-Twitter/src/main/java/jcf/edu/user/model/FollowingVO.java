package jcf.edu.user.model;

public class FollowingVO {
	
	private String userId;
	private String followingId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFollowingId() {
		return followingId;
	}
	public void setFollowingId(String followingId) {
		this.followingId = followingId;
	}
	public FollowingVO(String userId, String followingId) {
		super();
		this.userId = userId;
		this.followingId = followingId;
	}
	public FollowingVO() {
		super();
	}
	
	
}

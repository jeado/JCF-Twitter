package jcf.edu.user.model;

import java.util.Date;

public class TweetVO {
	   private int id;
	   private String register;
	   private String tweets;
	   private Date regDate;
	public TweetVO(int id, String register, String tweets, Date regDate) {
		super();
		this.id = id;
		this.register = register;
		this.tweets = tweets;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getTweets() {
		return tweets;
	}
	public void setTweets(String tweets) {
		this.tweets = tweets;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	   

}

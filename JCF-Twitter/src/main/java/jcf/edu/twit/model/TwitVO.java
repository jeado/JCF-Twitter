package jcf.edu.twit.model;

public class TwitVO {

	private int id;
	private String register;
	private String tweets;
	private String regDate;


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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}

package com.appbuilder.model;

public class GithubInfo {
	private String userName;
	private String repoName;
	
	
	public GithubInfo() {
		super();
	}
	
	public GithubInfo(String userName, String repoName) {
		super();
		this.userName = userName;
		this.repoName = repoName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String getURL() {
		return "https://github.com/" + userName + "/" + repoName;
	}
	public String getRepoURL() {
		return "https://github.com/" + userName + "/" + repoName + ".git";
	}
	
	@Override
	public String toString() {
		return "GithubInfo [userName=" + userName + ", repoName=" + repoName + "]";
	}	
	
}

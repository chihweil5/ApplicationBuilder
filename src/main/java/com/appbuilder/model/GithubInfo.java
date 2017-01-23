package com.appbuilder.model;

public class GithubInfo {
	private String userName;
	private String repoName;
	private String tags;
	private String localpath;
	
	public GithubInfo() {
		super();
	}
	
	public GithubInfo(String userName, String repoName, String tags, String localpath) {
		super();
		this.userName = userName;
		this.repoName = repoName;
		this.tags = tags;
		this.localpath = localpath + "/" + repoName;
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
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	

	public String getLocalpath() {
		return localpath;
	}

	public void setLocalpath(String localpath) {
		this.localpath = localpath;
	}

	public String getURL() {
		return "https://github.com/" + userName + "/" + repoName;
	}
	public String getRepoURL() {
		return "https://github.com/" + userName + "/" + repoName + ".git";
	}

	@Override
	public String toString() {
		return "GithubInfo [userName=" + userName + ", repoName=" + repoName + ", tags=" + tags + ", localpath="
				+ localpath + "]";
	}
	
}

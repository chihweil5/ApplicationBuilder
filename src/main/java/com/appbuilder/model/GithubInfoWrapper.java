package com.appbuilder.model;

import java.util.ArrayList;
import java.util.List;

public class GithubInfoWrapper {
	private List<GithubInfo> githubInfoList;

	public GithubInfoWrapper() {
		this.githubInfoList = new ArrayList<GithubInfo>();
	}

	public List<GithubInfo> getGithubInfoList() {
		return githubInfoList;
	}

	public void setGithubInfoList(List<GithubInfo> githubInfoList) {
		this.githubInfoList = githubInfoList;
	}
	
	public void add(GithubInfo githubInfo) {
        this.githubInfoList.add(githubInfo);
    }

	@Override
	public String toString() {
		return "GithubInfoWrapper [githubInfoList=" + githubInfoList + "]";
	}
	
	
}

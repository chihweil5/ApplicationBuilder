package com.appbuilder.service;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.stereotype.Service;

import com.appbuilder.model.GithubInfo;

@Service
public class GithubService {

	String newPath;
	
	public boolean isRepoValid(String url) throws MalformedURLException, IOException {

		System.out.println("connecting github..." + url);

		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("HEAD");
		return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
	}

	public void CloneRemoteRepository(GithubInfo githubInfo, String path)
			throws IOException, GitAPIException, InterruptedException {

		 // prepare a new folder for the cloned repository 
		 File dir = new File(path); 
		 File localPath = File.createTempFile(githubInfo.getRepoName(), "", dir);
		 System.out.println("Temp file : " + localPath.getAbsolutePath()); 
		 if(!localPath.delete()) { 
			 throw new IOException("Could not delete temporary file " + localPath); 
		 } 
		 
		 setNewPath(localPath.getAbsolutePath());

		 // then clone 
		 System.out.println("Cloning from " + githubInfo.getURL() + " to " + localPath); 
		 try (Git result = Git.cloneRepository().setURI(githubInfo.getRepoURL()).setDirectory(localPath).call()) { 
			 githubInfo.setLocalpath(localPath.getAbsolutePath());
			 System.out.println("Having repository: " + result.getRepository().getDirectory()); 
		 } catch (Exception ex) {
			 System.out.println("Fail to have repository"); 
		 }
	}
	
	public void getCommitByTags(GithubInfo g) throws IOException {
		RepositoryService service = new RepositoryService();
		List<org.eclipse.egit.github.core.Repository> repositories = service.getRepositories(g.getUserName());
		String sha = g.getTags();
		for (org.eclipse.egit.github.core.Repository repo : repositories) {
			if(repo.getName().equals(g.getRepoName())) {
				System.out.println("get commit in repository :" + repo.getName());
				CommitService commitService = new CommitService();
				RepositoryCommit commit = (RepositoryCommit) commitService.getCommit(repo, sha);
				System.out.println(commit.getCommit().getMessage());
			}
		}
	}
	
	public void getVersionByTags(GithubInfo g) {
		
	}

	public String getNewPath() {
		return newPath;
	}

	private void setNewPath(String newPath) {
		this.newPath = newPath;
	}
}
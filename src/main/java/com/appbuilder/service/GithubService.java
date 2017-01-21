package com.appbuilder.service;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.stereotype.Service;

import com.appbuilder.model.GithubInfo;
@Service
public class GithubService {
	
	String newPath;

	public void githubGetUser(GithubInfo g) throws IOException {
		System.out.println("connecting github...");
		RepositoryService service = new RepositoryService();
		for (Repository repo : service.getRepositories(g.getUserName()))
			System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
	}

	public boolean CloneRemoteRepository(String username, String reponame, String path) throws IOException, GitAPIException, InterruptedException {
		
		GithubInfo githubInfo = new GithubInfo(username, reponame);
		String dest = path;
		//check the repository
		if(!isRepoValid(githubInfo.getURL())) {
			return false;
		}
		
		// prepare a new folder for the cloned repository
		File dir = new File(dest);
		File localPath = File.createTempFile(reponame, "", dir);
		System.out.println("Temp file : " + localPath.getAbsolutePath());
		if (!localPath.delete()) {
			throw new IOException("Could not delete temporary file " + localPath);
		}
		
		setNewPath(localPath.getAbsolutePath());
		
		// then clone
		System.out.println("Cloning from " + githubInfo.getURL() + " to " + localPath);
		try (Git result = Git.cloneRepository().setURI(githubInfo.getRepoURL()).setDirectory(localPath).call()) {
			// Note: the call() returns an opened repository already which needs
			// to be closed to avoid file handle leaks!
			System.out.println("Having repository: " + result.getRepository().getDirectory());
		}catch(Exception ex) {
			System.out.println("Fail to have repository");
			return false;
		}
		
		return true;
	}
	
	
	
	public String getNewPath() {
		return newPath;
	}

	private void setNewPath(String newPath) {
		this.newPath = newPath;
	}

	private boolean isRepoValid(String url) throws MalformedURLException, IOException {
		
		System.out.println("connecting github..." + url);
		
		HttpURLConnection.setFollowRedirects(false);
	    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
	    con.setRequestMethod("HEAD");
	    return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		
	}
}
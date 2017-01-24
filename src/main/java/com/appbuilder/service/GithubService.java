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
import org.eclipse.jgit.api.GitCommand;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.springframework.stereotype.Service;

import com.appbuilder.helper.GithubHelper;
import com.appbuilder.model.GithubInfo;

@Service
public class GithubService {

	public boolean isRepoValid(String url) throws MalformedURLException, IOException {

		System.out.println("connecting github..." + url);

		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("HEAD");
		return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
	}

	public void CloneRemoteRepository(GithubInfo g, String path) throws IOException, GitAPIException, InterruptedException {

		 // prepare a new folder for the cloned repository 
		 File dir = new File(path); 
		 File localPath = File.createTempFile(g.getRepoName(), "", dir);
		 System.out.println("Temp file : " + localPath.getAbsolutePath()); 
		 if(!localPath.delete()) { 
			 throw new IOException("Could not delete temporary file " + localPath); 
		 } 

		 // then clone 
		 System.out.println("Cloning from " + g.getURL() + " to " + localPath); 
		 try (Git result = Git.cloneRepository().setURI(g.getRepoURL()).setDirectory(localPath).call()) { 
			 g.setLocalpath(localPath.getAbsolutePath());
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
	
	public void getVersionByTags(GithubInfo g) throws IOException, CheckoutConflictException, GitAPIException {
		File dir = new File(g.getLocalpath() + "/.git"); 
		try (Repository repository = GithubHelper.openRepository(dir)) {
			try (Git git = new Git(repository)) {
				System.out.println("get Version " + g.getTags());
				git.checkout().setCreateBranch( true ).setName( "new-branch" ).setStartPoint( g.getTags() ).call();
				git.checkout().setName( "new-branch").call();
			}
	    }
	}
}
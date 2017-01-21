package com.appbuilder.controller;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.appbuilder.model.GithubInfo;
import com.appbuilder.service.GithubService;
import com.appbuilder.service.GradleService;

@Controller
public class GithubController {
	
	@Autowired
    private GithubService githubService;
	@Autowired
	private GradleService gradleService;


	@RequestMapping(value = "/clone", method = RequestMethod.GET)
    public String showLoginPage() {
        return "clone";
    }
	
	@RequestMapping(value = "/clone", method = RequestMethod.POST)
	public String handleCloneRequest(@RequestParam String username, @RequestParam String reponame, @RequestParam String path, ModelMap model) throws IOException, GitAPIException, InterruptedException {

		if(!githubService.CloneRemoteRepository(username, reponame, path)){
			model.put("errorMsg", "Invalid user name or repository name");
			return "clone";
		}
		String newPath = githubService.getNewPath();
		//gradleService.executeGradle(newPath);
		model.addAttribute("githubInfo", new GithubInfo());
		return "clone-success";
	}
}

package com.appbuilder.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.appbuilder.model.GithubInfo;
import com.appbuilder.model.GithubInfoWrapper;
import com.appbuilder.service.GithubService;
import com.appbuilder.service.GradleService;

@Controller
public class BuilderController {
	
	@Autowired
    private GithubService githubService;
	@Autowired
	private GradleService gradleService;
	
	private List<GithubInfo> githubInfoList;
	
	@RequestMapping(value = "/appbuilder", method = RequestMethod.GET)
    public String showProjectNumPage() {
        return "appbuilder";
    }
	
	@RequestMapping(value = "/appbuilder", method = RequestMethod.POST)
    public String setProjectNum(ModelMap model, @RequestParam String numOfProj) {
		System.out.println("Project num: " + numOfProj);
		model.addAttribute("numOfProj", numOfProj);
        return "redirect:projectform";
    }
	
	@RequestMapping(value = "/projectform", method = RequestMethod.GET)
    public String showProjectFormPage(ModelMap model, @RequestParam String numOfProj) {
		GithubInfoWrapper githubInfoWrapper = new GithubInfoWrapper();
		for(int i = 0; i < Integer.parseInt(numOfProj); i++) {
			githubInfoWrapper.add(new GithubInfo());
		}
		System.out.println("GithubInfoWrapper size: " + githubInfoWrapper.getGithubInfoList().size());
		model.addAttribute("githubInfoWrapper", githubInfoWrapper);
        return "projectform";
    }
	/*@RequestMapping(value = "/builder", method = RequestMethod.GET)
    public String showClonePage(ModelMap model) {
		GithubInfoWrapper githubInfoWrapper = new GithubInfoWrapper();
		githubInfoWrapper.add(new GithubInfo("a","b","c","d"));
		githubInfoWrapper.add(new GithubInfo("e","f","g","h"));
		System.out.println("GithubInfoWrapper size: " + githubInfoWrapper.getGithubInfoList().size());
		List<GithubInfo> test = githubInfoWrapper.getGithubInfoList();
		System.out.println(test.get(0).getUserName());
		model.addAttribute("githubInfoWrapper", githubInfoWrapper);
        return "appbuilder";
    }*/
    
	@RequestMapping(value = "/projectform", method = RequestMethod.POST)
    public String dataRequest(ModelMap model, GithubInfoWrapper githubInfoWrapper) throws MalformedURLException, IOException, GitAPIException, InterruptedException {
		System.out.println(githubInfoWrapper.toString());
		githubInfoList = githubInfoWrapper.getGithubInfoList();
        return "redirect:result";
    }
	
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showResultPage(ModelMap model) throws IOException, GitAPIException, InterruptedException {
		List<String>msg = new ArrayList<String>();
		List<String>status = new ArrayList<String>();
		//List<GithubInfo> githubInfoList = githubInfoWrapper.getGithubInfoList();
		System.out.println(githubInfoList.toString());
		
		for(int i = 0; i < githubInfoList.size(); i++ ) {
			// check the repository
			if (!githubService.isRepoValid(githubInfoList.get(i).getURL())) {
				System.out.println("errorMsg: Invalid user name or repository name");
				msg.add("Invalid URL");
				status.add("Failed");
				continue;
			}
			
			//check the commit hash
			if(!githubInfoList.get(i).getTags().equals("")) {
				
				System.out.println("Start checking out the commit....");
				// get commit
				String commit = githubService.getCommitByTags(githubInfoList.get(i));
				
				if(commit.equals("Commit Hash not found")) {
					System.out.println("errorMsg: Error message: Invalid SHA tag" );
					msg.add("Invalid SHA tag");
					status.add("Failed");
					continue;
				}
				else {
					System.out.println("Building Version: " + commit + "(" + githubInfoList.get(i).getTags() + ")" );
					msg.add("Building Version: " + commit + "(" + githubInfoList.get(i).getTags() + ")");
					System.out.println("Start cloning....");
					// clone
					githubService.CloneRemoteRepository(githubInfoList.get(i));
					githubService.getVersionByTags(githubInfoList.get(i));
				}
			}
			else {
				System.out.println("Building the latest Version" );
				msg.add("Building the latest Version");
				System.out.println("Start cloning latest version....");
				// clone
				githubService.CloneRemoteRepository(githubInfoList.get(i));
			}
			
			System.out.println(githubInfoList.get(i).toString());
			System.out.println("Start Building....");
			if(!gradleService.executeGradle(githubInfoList.get(i).getLocalpath())) {
				System.out.println("--------------------------------------------------");
				System.out.println("Fail to build the app project");
				System.out.println("Error message: " + gradleService.getErrorMsg());
				System.out.println("--------------------------------------------------");
				model.put("errorMsg", "Error message: " + gradleService.getErrorMsg());
				msg.set(i, "Error message: " + gradleService.getErrorMsg());
				status.set(i, "Failed");
				continue;
			}
			status.add("Built");
		}
		System.out.println(msg.toString());
		System.out.println(status.toString());
		model.addAttribute("githubInfoList", githubInfoList);
		model.addAttribute("Msg", msg);
		model.addAttribute("Status", status);
		return "result";
		
	}
	
	
	@RequestMapping(value = "/clone-build", method = RequestMethod.GET)
    public String showSuccessPage() {
        return "clone-build";
    }
	
}

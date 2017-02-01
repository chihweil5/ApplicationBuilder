package com.appbuilder.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	private List<String> msg;
	private List<String> status;
	
	private static final int BUFFER_SIZE = 4096;

	public BuilderController() {
		super();
		githubInfoList = new ArrayList<GithubInfo>();
		msg = new ArrayList<String>();
		status = new ArrayList<String>();
	}

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
			githubInfoWrapper.getGithubInfoList().add(new GithubInfo());
		}
		System.out.println("GithubInfoWrapper size: " + githubInfoWrapper.getGithubInfoList().size());
		model.addAttribute("githubInfoWrapper", githubInfoWrapper);
        return "projectform";
    }
    
	@RequestMapping(value = "/projectform", method = RequestMethod.POST)
    public void HandleCloneAndBuild(ModelMap model, GithubInfoWrapper githubInfoWrapper) throws MalformedURLException, IOException, GitAPIException, InterruptedException {
		System.out.println(githubInfoWrapper.toString());
		githubInfoList = githubInfoWrapper.getGithubInfoList();
		int projectNum = githubInfoList.size();
		status = new ArrayList<String>(Collections.nCopies(projectNum, "Not Scheduled"));
		msg = new ArrayList<String>(Collections.nCopies(projectNum, ""));
		
		System.out.println(githubInfoList.toString());
		
		for(int i = 0; i < projectNum; i++ ) {
			
			// update the status to scheduled
			status.set(i,"Scheduled");
			System.out.println("checking the user name and repository name");
			
			// check the repository
			if (!githubService.isRepoValid(githubInfoList.get(i).getURL())) {
				System.out.println("--------------------------------------------------");
				System.out.println("errorMsg: Invalid user name or repository name");
				System.out.println("--------------------------------------------------");
				msg.set(i, "Invalid user name or repository name");
				status.set(i,"Failed");
				githubInfoList.get(i).setLocalpath("");
				continue;
			}
			
			System.out.println("Start checking out the commit....");
			// check the commit hash and clone
			if(!githubInfoList.get(i).getTags().equals("")) {
				String commit = githubService.getCommitByTags(githubInfoList.get(i));
				
				if(commit.equals("Commit Hash not found")) {
					System.out.println("--------------------------------------------------");
					System.out.println("errorMsg: Error message: Invalid SHA tag" );
					System.out.println("--------------------------------------------------");
					
					msg.set(i, "Invalid SHA tag");
					status.set(i, "Failed");
					githubInfoList.get(i).setLocalpath("");
					continue;
				}
				else {
					System.out.println("--------------------------------------------------");
					System.out.println("Building Version: " + commit + "(" + githubInfoList.get(i).getTags() + ")" );
					System.out.println("Start cloning....");
					System.out.println("--------------------------------------------------");
					
					githubService.CloneRemoteRepository(githubInfoList.get(i));
					githubService.getVersionByTags(githubInfoList.get(i));
					msg.set(i, "Building Version: " + commit + "(" + githubInfoList.get(i).getTags() + ")");
				}
			}
			else {
				System.out.println("--------------------------------------------------");
				System.out.println("Building the latest Version" );
				System.out.println("Start cloning latest version....");
				System.out.println("--------------------------------------------------");
				
				githubService.CloneRemoteRepository(githubInfoList.get(i));
				msg.set(i, "Building the latest Version");
			}
			
			System.out.println("Start Building....");
			
			// build the project
			if(!gradleService.executeGradle(githubInfoList.get(i).getLocalpath())) {
				System.out.println("--------------------------------------------------");
				System.out.println("Fail to build the app project");
				System.out.println("Error message: " + gradleService.getErrorMsg());
				System.out.println("--------------------------------------------------");
				msg.set(i, gradleService.getErrorMsg());
				status.set(i, "Failed");
				continue;
			}
			status.set(i, "Built");
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println("projects are completed");
		System.out.println(githubInfoList.toString());
		System.out.println(msg.toString());
		System.out.println(status.toString());
		System.out.println("--------------------------------------------------");
		
    }
	
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String showResultPage(ModelMap model, @RequestParam(value = "select1", required = false) String select1, @RequestParam(value = "select2", required = false) String select2) throws IOException, GitAPIException, InterruptedException {
		//System.out.println(select1 + " " + select2);
		int num = githubInfoList.size();
		List<GithubInfo> _githubInfoList = new ArrayList<GithubInfo>();
		List<String> _msg = new ArrayList<String>();
		List<String> _status = new ArrayList<String>();
		List<String> repoList = new ArrayList<String>();
		
		repoList = createRepoNameList(num);
		
		//System.out.println("***********************" + repoList.toString()); 
		
		model.addAttribute("repoList", repoList);

		if(select1 != null && select2 != null) {
			showResultTable(_githubInfoList, _msg, _status, select1, select2, num);
		}
		//System.out.println("----------------" + _githubInfoList.toString()); 
		model.addAttribute("_githubInfoList", _githubInfoList);
		model.addAttribute("_Msg", _msg);
		model.addAttribute("_Status", _status);
		
		return "result";
	}
	
	@RequestMapping(value = "/dataquery", method = RequestMethod.GET)
	public String showDataQueryPage(ModelMap model, @RequestParam(value = "select1", required = false) String select1, @RequestParam(value = "select2", required = false) String select2) throws IOException, GitAPIException, InterruptedException {
		//System.out.println(select1 + " " + select2);
		int num = githubInfoList.size();
		List<GithubInfo> _githubInfoList = new ArrayList<GithubInfo>();
		List<String> _msg = new ArrayList<String>();
		List<String> _status = new ArrayList<String>();
		List<String> repoList = new ArrayList<String>();
		
		repoList = createRepoNameList(num);
		
		model.addAttribute("repoList", repoList);

		if(select1 != null && select2 != null) {
			showResultTable(_githubInfoList, _msg, _status, select1, select2, num);
		}
		//System.out.println("----------------" + _githubInfoList.toString()); 
		model.addAttribute("_githubInfoList", _githubInfoList);
		model.addAttribute("_Status", _status);
		
		return "dataquery";
	}
	
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public String doDownload(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		
		System.out.println("downloading apk files from " + githubInfoList.get(id).getRepoName() + "...");

		List<String> filePaths = findApkFile(githubInfoList.get(id).getLocalpath());
		//System.out.println(filePaths.toString());
        ServletContext context = request.getSession().getServletContext();
        
        for(int i = 0; i < filePaths.size(); i++) {
        	File downloadFile = new File(filePaths.get(i));
            FileInputStream inputStream = new FileInputStream(downloadFile);
             
            // get MIME type of the file
            String mimeType = context.getMimeType(filePaths.get(i));
            if (mimeType == null) {
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
            //System.out.println("MIME type: " + mimeType);
     
            // set content attributes for the response
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
     
            // set headers for the response
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"",
                    downloadFile.getName());
            response.setHeader(headerKey, headerValue);
     
            // get output stream of the response
            OutputStream outStream = response.getOutputStream();
     
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
     
            // write bytes read from the input stream into the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            
            inputStream.close();
            outStream.close();
        }
        return "redirect:dataquery";
    }

	private List<String> createRepoNameList(int num) {
		int i,j;
		List<String> repoList = new ArrayList<String>();
		for(i = 0; i < num; i++) {
			String tmpName = githubInfoList.get(i).getUserName() + "/" + githubInfoList.get(i).getRepoName();
			for(j = 0; j < repoList.size(); j++) {
				if(tmpName.equals(repoList.get(j))) {
					break;
				}
			}
			if(j == repoList.size()) {
				repoList.add(tmpName);
			}
		}
		return repoList;
	}
	
	private void showResultTable(List<GithubInfo> t_githubInfoList, List<String> t_msg, List<String> t_status, String select1, String select2, int num){
		int i;
		
		if(select1.equals("Name")) {
			for(i = 0; i < num; i++) {
				String tmpName = githubInfoList.get(i).getUserName() + "/" + githubInfoList.get(i).getRepoName();
				if(tmpName.equals(select2)) {
					t_githubInfoList.add(githubInfoList.get(i));
					t_msg.add(msg.get(i));
					t_status.add(status.get(i));
				}
			}
			//System.out.println("----------------" + _githubInfoList.toString()); 
		}
		else if(select1.equals("Status")) {
			for(i = 0; i < num; i++) {
				if(status.get(i).equals(select2)) {
					t_githubInfoList.add(githubInfoList.get(i));
					t_msg.add(msg.get(i));
					t_status.add(status.get(i));
				}
			}
		}
		else {
			
			for(i = 0; i < num; i++) {
				t_githubInfoList.add(githubInfoList.get(i));
				t_msg.add(msg.get(i));
				t_status.add(status.get(i));
			}
		}
	}
	
	private List<String> findApkFile(String path) {
		List<String> filePath = new ArrayList<String>();
		
		try {
            Process p = Runtime.getRuntime().exec(new String[]{"find", path, "-name", "*.apk"});
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                filePath.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return filePath;
	}
}

package com.appbuilder.service;

import java.io.File;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GradleService {
	
	private static final Logger logger = LoggerFactory.getLogger(GradleService.class);
	private Exception errorMsg;
	
	public boolean executeGradle(String path) {
		System.out.println("Generating .apk file....");
		String dest = path;
		File projectDir = new File(dest);
		ProjectConnection connection = GradleConnector.newConnector().forProjectDirectory(projectDir).connect();

		try {
			connection.newBuild().forTasks("assembleDebug").run();
			
		} catch(Exception e){
			System.out.println("ERROR: " + e);
			errorMsg = e;
			return false;
		} finally {
			connection.close();
		}
		
		return true;
	}

	public Exception getErrorMsg() {
		return errorMsg;
	}

	
}

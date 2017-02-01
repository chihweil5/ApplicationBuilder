package com.appbuilder.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GradleService {
	
	private static final Logger logger = LoggerFactory.getLogger(GradleService.class);
	private String errorMsg;
	
	public boolean executeGradle(String path) {
		/*System.out.println("Generating .apk file....");
		String dest = path;
		System.out.println("in the repository..." + dest);
		File projectDir = new File(dest);
		File gradlefile = new File("/usr/local/tomcat/gradle-3.3/daemon/3.3");
		ProjectConnection connection = GradleConnector.newConnector().useInstallation(gradlefile).forProjectDirectory(projectDir).connect();

		try {
			connection.newBuild().forTasks("assembleDebug").run();
			
		} catch(Exception e){
			System.out.println("ERROR: " + e);
			errorMsg = e;
			return false;
		} finally {
			connection.close();
		}*/

		try {
            Process p = Runtime.getRuntime().exec(new String[]{"gradle", "-p", path, "assembleDebug"});
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                if(line.indexOf("FAILED") > -1) {
                	errorMsg = "Gradle Build Failed";
                	return false;
                }
            }
        } catch (IOException e) {
        	e.printStackTrace();
            errorMsg = "Error Message:" + e;
            return false;
        }
		return true;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	
}

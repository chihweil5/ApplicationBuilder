package com.appbuilder.service;

import java.io.File;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.springframework.stereotype.Service;

@Service
public class GradleService {
	public void executeGradle(String path) {
		String dest = path;
		File projectDir = new File(dest);
		ProjectConnection connection = GradleConnector.newConnector().forProjectDirectory(projectDir).connect();

		try {
			connection.newBuild().forTasks("assembleDebug").run();
		} finally {
			connection.close();
		}
	}
}

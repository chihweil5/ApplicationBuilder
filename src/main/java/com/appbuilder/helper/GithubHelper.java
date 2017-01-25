package com.appbuilder.helper;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GithubHelper {
	
	public static Repository openRepository(File url) throws IOException {
		//System.out.println("in helper " + url.toString());
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(url)
                    .readEnvironment() // scan environment GIT_* variables
                    .findGitDir() // scan up the file system tree
                    .build();
        return repository;
        
    }
}

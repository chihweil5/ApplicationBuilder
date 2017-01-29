package com.appbuilder.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	private static final int BUFFER_SIZE = 4096;
	private String filePath;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String showPage(){
		return "upload";
	}
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		//MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		//MultipartFile file = multipartRequest.getFile(" file ");   
	    //String name = file.getOriginalFilename();  
		System.out.println("HIHHI");
		if (!file.isEmpty()) {
			System.out.println("~~~~~~~");
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				filePath = serverFile.getAbsolutePath();
				return "download";
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
				return "/";
			}
		} else {
			System.out.println("~asdad~~~~~");
			System.out.println("You failed to upload " + name + " because the file was empty.");
			return "/";
		}
	}
	
	/**
     * Method for handling file download request from client
     */
    @RequestMapping(value = "/download.do",method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
 
        // get absolute path of the application
        ServletContext context = request.getSession().getServletContext();
/*        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);
*/ 
        // construct the complete absolute path of the file
       // String fullPath = appPath + filePath;      
        File downloadFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        // get MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
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
}

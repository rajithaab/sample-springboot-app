package com.sample.rest.data.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.rest.data.model.Document;
import com.sample.rest.data.model.DocumentMetaData;

@RestController
public class RestMetaDataFileController {
	private static final Logger logger = LoggerFactory.getLogger(RestMetaDataFileController.class);
	
	@Autowired
    private IDocumentPersistService filePersistService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	 public @ResponseBody DocumentMetaData handleFileUpload(
	            @RequestParam(value="file", required=true) MultipartFile file ,
	            @RequestParam(value="person", required=true) String person,
	            @RequestParam(value="date", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		
		try {
            Document document = new Document(file.getBytes(), file.getOriginalFilename(), date, person );
            filePersistService.save(document);
            return document.getMetadata();
        } catch (RuntimeException e) {
        	logger.error("Error while uploading.", e);
            throw e;
        } catch (Exception e) {
        	logger.error("Error while uploading.", e);
            throw new RuntimeException(e);
        }  
	}

}

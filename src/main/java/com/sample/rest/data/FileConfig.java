package com.sample.rest.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("file")
public class FileConfig {
	private String maxSize;
	private String maxRequesSize;
	private String uploadPath;
	private String metadataFileName;
	
	public String getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}
	public String getMaxRequesSize() {
		return maxRequesSize;
	}
	public void setMaxRequesSize(String maxRequesSize) {
		this.maxRequesSize = maxRequesSize;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getMetadataFileName() {
		return metadataFileName;
	}
	public void setMetadataFileName(String metadataFileName) {
		this.metadataFileName = metadataFileName;
	}
	
		
}

package com.sample.rest.data.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rest.data.FileConfig;
import com.sample.rest.data.model.Document;

@Service("documentDao")
public class FileSystemDocumentDao{
	
	private static final Logger LOG = Logger.getLogger(FileSystemDocumentDao.class);
	@Autowired
	private FlleStytemDocumentDaoHelper daoHelper;
	@Autowired
	private FileConfig fileConfig;
	
	@PostConstruct
    public void init() {
		daoHelper.createDirectory(fileConfig.getUploadPath());
    }

	public void insert(Document document) {
		try {
			daoHelper.createDocumentDirectory(document);
			daoHelper.saveFile(document);
			saveMetaDatainFileSystem(document);
		} catch (IOException e) {
			String message = "Error while inserting document";
            LOG.error(message, e);
            throw new RuntimeException(message, e);
		}
	}
	private void saveMetaDatainFileSystem(Document document) throws IOException {
		String path = daoHelper.getDirectoryPath(document);
		Properties props = document.createProperties();
		File tempFile = new File(path);
		File f = new File(tempFile, fileConfig.getMetadataFileName());
		FileOutputStream out = new FileOutputStream(f);
		props.store(out, "Document meta data");
	}


}

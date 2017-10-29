package com.sample.rest.data.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rest.data.model.Document;
import com.sample.rest.data.service.FileConfig;

@Service("documentDao")
public class FileSystemDocumentDaoImpl implements IDocumentFileSystemDao{
	
	private static final Logger LOG = Logger.getLogger(FileSystemDocumentDaoImpl.class);
	public static final String PATH = "E://sample";
	public static final String META_DATA_FILE_NAME = "metadata.properties";
	
	@Autowired
	private MetaDataDBDao metadataDao;

	@Autowired
	private FileConfig fileConfig;
	
	@PostConstruct
    public void init() {
        createDirectory(fileConfig.getUploadPath());
    }
	
	private void createDirectory(String path) {
		 File file = new File(path);
	     file.mkdirs();
	}

	public void insert(Document document) {
		try {
			createDocumentDirectory(document);
			saveFileData(document);
			saveMetaData(document);
		} catch (IOException e) {
			String message = "Error while inserting document";
            LOG.error(message, e);
            throw new RuntimeException(message, e);
		}
	}
	
	private String createDocumentDirectory(Document document) {
        String path = getDirectoryPath(document);
        createDirectory(path);
        return path;
    }

	private String getDirectoryPath(Document document) {
	       return getDirectoryPath(document.getUuid());
    }
    
    private String getDirectoryPath(String uuid) {
        StringBuilder sb = new StringBuilder();
        sb.append(PATH).append(File.separator).append(uuid);
        String path = sb.toString();
        return path;
    }
	

	private void saveMetaData(Document document) throws IOException {
		String path = getDirectoryPath(document);
        Properties props = document.createProperties();
        File f = new File(new File(path), fileConfig.getMetadataFileName());
        OutputStream out = new FileOutputStream( f );
        props.store(out, "Document meta data");
        
        metadataDao.create(document.getMetadata());
	}

	private void saveFileData(Document document) throws IOException {
		String path = getDirectoryPath(document);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(new File(path), document.getFileName())));
        stream.write(document.getFileData());
        stream.close();
	}

}

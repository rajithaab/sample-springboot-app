package com.sample.rest.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.rest.data.dao.FileSystemDocumentDao;
import com.sample.rest.data.dao.MetaDataDBDao;
import com.sample.rest.data.model.Document;
import com.sample.rest.data.model.DocumentMetaData;

@Component
public class DocumentPersistServiceImpl implements IDocumentPersistService{

	@Autowired
    private FileSystemDocumentDao documentDao;
	
	@Autowired
	private MetaDataDBDao metaDataDBDao;
	
	public DocumentMetaData save(Document document) {
		documentDao.insert(document); 
		metaDataDBDao.create(document.getMetadata());
	    return document.getMetadata();
	}
}

package com.sample.rest.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rest.data.dao.IDocumentFileSystemDao;
import com.sample.rest.data.model.Document;
import com.sample.rest.data.model.DocumentMetaData;

@Service("filePersistService")
public class DocumentPersistServiceImpl implements IDocumentPersistService{

	@Autowired
    private IDocumentFileSystemDao documentDao;
	
	public DocumentMetaData save(Document document) {
		documentDao.insert(document); 
	    return document.getMetadata();
	}

}

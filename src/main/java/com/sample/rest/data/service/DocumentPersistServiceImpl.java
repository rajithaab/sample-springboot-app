package com.sample.rest.data.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.rest.data.dao.FileSystemDocumentDao;
import com.sample.rest.data.dao.MetaDataDBDao;
import com.sample.rest.data.model.Document;
import com.sample.rest.data.model.DocumentMetaData;

@Component
@Transactional
public class DocumentPersistServiceImpl implements IDocumentPersistService{

	@Autowired
    private FileSystemDocumentDao documentDao;
	
	@Autowired
	private MetaDataDBDao metaDataDBDao;
	
	/*@Autowired
	private MetadataRepository metadataRepository;*/
	
	public DocumentMetaData save(Document document) {
		documentDao.insert(document); 
		metaDataDBDao.create(document.getMetadata());
		/*DocumentMetaData docMetadata = document.getMetadata();
		MetaData metadata = new MetaData(docMetadata.getUuid(), docMetadata.getFileName(), docMetadata.getDocumentDate(), docMetadata.getPersonName());
		metadataRepository.save(metadata);*/
	    return document.getMetadata();
	}
}

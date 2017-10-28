package com.sample.rest.data.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.rest.data.model.DocumentMetaData;

@Repository
@Transactional	
public class MetaDataDBDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void create(DocumentMetaData docMetadata) {
		MetaData metadata = new MetaData(docMetadata.getUuid(), docMetadata.getFileName(), docMetadata.getDocumentDate(), docMetadata.getPersonName());
		entityManager.persist(metadata);
	}

}
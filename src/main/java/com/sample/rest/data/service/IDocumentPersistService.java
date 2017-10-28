package com.sample.rest.data.service;

import com.sample.rest.data.model.Document;
import com.sample.rest.data.model.DocumentMetaData;

public interface IDocumentPersistService {
	
	/**
     * Saves a document in the file system and saves metadata in h2database.
     * 
     * @param document A document
     * @return DocumentMetadata The meta data of the saved document
     */
    public DocumentMetaData save(Document document);
}

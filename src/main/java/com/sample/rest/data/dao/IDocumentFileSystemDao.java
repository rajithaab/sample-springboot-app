package com.sample.rest.data.dao;

import com.sample.rest.data.model.Document;

public interface IDocumentFileSystemDao {
	/**
     * Inserts a document in the data store.
     * 
     * @param document A Document
     */
    void insert(Document document);
}

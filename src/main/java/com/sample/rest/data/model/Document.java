package com.sample.rest.data.model;

import java.util.Date;

public class Document extends DocumentMetaData{
	
	private byte[] fileData;
    
    public Document( byte[] fileData, String fileName, Date documentDate, String personName) {
        super(fileName, documentDate, personName);
        this.fileData = fileData;
    }
    
    public Document(DocumentMetaData metadata) {
        super(metadata.getUuid(), metadata.getFileName(), metadata.getDocumentDate(), metadata.getPersonName());
    }

    public byte[] getFileData() {
        return fileData;
    }
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
    public DocumentMetaData getMetadata() {
        return new DocumentMetaData(getUuid(), getFileName(), getDocumentDate(), getPersonName());
    }
}

package com.sample.rest.data.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "METADATA")
public class MetaData {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
	
    @Column(name="UUID")
    private String uuid;
    
    @Column(name="FILE_NAME")
    private String fileName;
    
    @Column(name="DOCUMENT_DATE")
    private Date documentDate;
    
    @Column(name="PERSON_NAME")
    private String personName;
    
    protected MetaData() {
    	
    }
    
    public MetaData(String uuid, String fileName, Date documentDate, String personName) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.documentDate = documentDate;
		this.personName = personName;
	}
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	} 
}

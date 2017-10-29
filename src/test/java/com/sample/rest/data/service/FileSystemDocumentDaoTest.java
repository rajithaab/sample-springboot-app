package com.sample.rest.data.service;

import java.io.File;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sample.rest.data.FileConfig;
import com.sample.rest.data.dao.FileSystemDocumentDao;
import com.sample.rest.data.dao.MetaDataDBDao;
import com.sample.rest.data.model.Document;

@RunWith(PowerMockRunner.class)
public class FileSystemDocumentDaoTest {
	@InjectMocks
	FileSystemDocumentDao fileSystemDoc;
	@Mock
	FileConfig config;
	@Mock
	MetaDataDBDao metaDataDBDao;
	@Mock
	Document document;
	
	@Test
	public void testInsert() {
		Mockito.doNothing().doReturn(document);
	}
	
	@Test
	public void testCreateDirectory() {
		fileSystemDoc.init();
	}
}

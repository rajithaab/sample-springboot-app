package com.sample.rest.data.service;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sample.rest.data.dao.FileSystemDocumentDao;
import com.sample.rest.data.model.Document;

@RunWith(PowerMockRunner.class)
public class DocumentPersistServiceTest {
	
	@Mock
	FileSystemDocumentDao documumetDao;
	
	@InjectMocks
	private DocumentPersistServiceImpl persistService;
	
	@Mock
	Document document;
	
	@Test
	public void testPassingDocument() {
		when(persistService.save(document)).thenReturn(document);
	}
}

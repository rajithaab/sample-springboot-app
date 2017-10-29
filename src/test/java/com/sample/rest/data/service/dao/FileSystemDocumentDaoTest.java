package com.sample.rest.data.service.dao;

import com.sample.rest.data.dao.FileConfig;
import com.sample.rest.data.dao.FileSystemDocumentDao;
import com.sample.rest.data.dao.FlleStytemDocumentDaoHelper;
import com.sample.rest.data.dao.MetaDataDBDao;
import com.sample.rest.data.model.Document;
import com.sample.rest.data.model.DocumentMetaData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.print.Doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileSystemDocumentDao.class)
public class FileSystemDocumentDaoTest {

    @Mock
    private MetaDataDBDao metaDataDBDao;

    @Mock
    private FileConfig fileConfig;

    @Mock
    private Document document;

    @Mock
    private FlleStytemDocumentDaoHelper daoHelper;

    @Mock
    private FileOutputStream fileOutputStream;

    @Mock
    private File f;

    @Mock
    private Properties properties;

    @InjectMocks
    FileSystemDocumentDao fileSystemDocumentDao;

    @Test
    public void insertTest() throws Exception{
        doNothing().when(metaDataDBDao).create(any(DocumentMetaData.class));
        when(metaDataDBDao.getDocumentId(anyString())).thenReturn("testPath");
        when(fileConfig.getMetadataFileName()).thenReturn("metadataFileName");

        doNothing().when(daoHelper).createDirectory(anyString());
        doNothing().when(daoHelper).saveFile(any(Document.class));
        when(daoHelper.getDirectoryPath(anyString())).thenReturn("dirPath");
        when(daoHelper.getDirectoryPath(any(Document.class))).thenReturn("dirPath");
        whenNew(File.class).withAnyArguments().thenReturn(f);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);
        when(document.createProperties()).thenReturn(properties);
        doNothing().when(properties).store(any(OutputStream.class), anyString());
        fileSystemDocumentDao.insert(document);
    }

    @Test(expected = RuntimeException.class)
    public void insertTestException() throws Exception{
        doNothing().when(metaDataDBDao).create(any(DocumentMetaData.class));
        when(metaDataDBDao.getDocumentId(anyString())).thenReturn("testPath");
        when(fileConfig.getMetadataFileName()).thenReturn("metadataFileName");

        doNothing().when(daoHelper).createDirectory(anyString());
        doThrow(new IOException()).when(daoHelper).saveFile(any(Document.class));
        when(daoHelper.getDirectoryPath(anyString())).thenReturn("dirPath");
        when(daoHelper.getDirectoryPath(any(Document.class))).thenReturn("dirPath");
        whenNew(File.class).withAnyArguments().thenReturn(f);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);
        when(document.createProperties()).thenReturn(properties);
        doNothing().when(properties).store(any(OutputStream.class), anyString());
        fileSystemDocumentDao.insert(document);
    }

    @Test
    public void insertTestExceptionMessage() throws Exception{
        doNothing().when(metaDataDBDao).create(any(DocumentMetaData.class));
        when(metaDataDBDao.getDocumentId(anyString())).thenReturn("testPath");
        when(fileConfig.getMetadataFileName()).thenReturn("metadataFileName");

        doNothing().when(daoHelper).createDirectory(anyString());
        doThrow(new IOException()).when(daoHelper).saveFile(any(Document.class));
        when(daoHelper.getDirectoryPath(anyString())).thenReturn("dirPath");
        when(daoHelper.getDirectoryPath(any(Document.class))).thenReturn("dirPath");
        whenNew(File.class).withAnyArguments().thenReturn(f);
        whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fileOutputStream);
        when(document.createProperties()).thenReturn(properties);
        doNothing().when(properties).store(any(OutputStream.class), anyString());
        try {
            fileSystemDocumentDao.insert(document);
        } catch(RuntimeException e){
            assertEquals(e.getMessage(), "Error while inserting document");
            return;
        }
        fail();
    }
}

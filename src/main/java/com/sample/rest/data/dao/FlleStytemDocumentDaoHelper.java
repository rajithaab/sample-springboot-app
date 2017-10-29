package com.sample.rest.data.dao;

import com.sample.rest.data.model.Document;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

@Component
public class FlleStytemDocumentDaoHelper {

    public static final String PATH = "E://sample";
    public static final String META_DATA_FILE_NAME = "metadata.properties";

    public String createDocumentDirectory(Document document) {
        String path = getDirectoryPath(document);
        createDirectory(path);
        return path;
    }

    public String getDirectoryPath(Document document) {
        return getDirectoryPath(document.getUuid());
    }

    public String getDirectoryPath(String uuid) {
        StringBuilder sb = new StringBuilder();
        sb.append(PATH).append(File.separator).append(uuid);
        String path = sb.toString();
        return path;
    }


   

    public void saveFile(Document document) throws IOException {
        String path = getDirectoryPath(document);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(new File(path), document.getFileName())));
        stream.write(document.getFileData());
        stream.close();
    }

    public void createDirectory(String path) {
        File file = new File(path);
        file.mkdirs();
    }
    
    
}

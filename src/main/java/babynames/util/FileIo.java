package babynames.util;

import org.apache.commons.io.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileIo {

    private final static Logger logger = LoggerFactory.getLogger(FileIo.class);

    public FileIo() {
    }

    public String retrieveContent(String path) {
        logger.info("Retrieving the content from file: " + path);
        String content = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            if (classLoader.getResourceAsStream(path) != null) {
                content = IOUtils.toString(classLoader.getResourceAsStream(path), "UTF-8");
            } else {
                content = IOUtils.toString(new FileReader(path));
            }
            logger.info("Done retrieving content from file: " + path);
        } catch (IOException e) {
            logger.error("Error retrieving content from file: " + path + ". Error: " + e);
        }
        return content;
    }


    public void writeContent(String content, String path, boolean append) {
        logger.info("Writing content to file: " + path);
        try {
            FileUtils.writeStringToFile(new File(path), content, "UTF-8", append);
            logger.info("Done writing content to file: " + path);
        } catch (IOException e) {
            logger.error("Error writing content to file: " + path + ". Error: " + e);
            e.printStackTrace();
        }
    }
}
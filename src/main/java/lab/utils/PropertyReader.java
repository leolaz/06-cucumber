package lab.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    private static Logger logger = LogManager.getLogger(PropertyReader.class);

    static {
        properties = new Properties();
        try(FileInputStream fis = new FileInputStream("src/test/resources/test.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            logger.catching(e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}

package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String readProperty(String key){
        File file=new File("configuration.properties");
        Properties properties=new Properties();
        //this properties object will read the properties file.
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //more actions surround try and catch
        return properties.getProperty(key);
    }
}
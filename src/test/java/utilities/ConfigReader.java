package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        String filePath = "Configuration.properties";

        try {
            FileInputStream file = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Properties not founded!");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

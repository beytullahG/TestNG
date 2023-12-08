package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {// The static block runs before everything else

        String filePath = "configuration.properties";
        try {

            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            System.out.println("Properties file could not be read.");
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);

    }
}

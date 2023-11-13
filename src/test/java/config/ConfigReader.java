package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/java/config/config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(getProperty("Url1"));
    }

    public String getBaseUrl1() {
        return properties.getProperty("Url1");
    }
    public String getBaseUrl2() {
        return properties.getProperty("Url2");
    }
    public String getBaseUrl3() {
        return properties.getProperty("Url3");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
    public String getUsernameInvalid() {
        return properties.getProperty("usernameInvalid");
    }

    public String getPasswordInvalid() {
        return properties.getProperty("passwordInvalid");
    }
}


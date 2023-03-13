package by.teachmeskills.util;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class PropertiesLoader {

    public static Properties loadProperties(String fileName) {
        log.info("Properties is being loaded from file {}", fileName);
        Properties properties = new Properties();
        try (InputStream input = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            //load a properties file from class path, inside static method
            properties.load(input);
        } catch (IOException ex) {
            log.error("The exception has occurred: {}", ex.getLocalizedMessage());
        }
        return properties;
    }

    public static Properties loadProperties() {
        return loadProperties("configuration.properties");
    }
}

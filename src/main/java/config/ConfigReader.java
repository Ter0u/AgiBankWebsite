package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) { // pega do classpath
            if (input == null) {
                throw new RuntimeException("Não foi possível encontrar config.properties no classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar config.properties: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("cfg/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getServerAddress() {
        return properties.getProperty("server_address");
    }

    public String getClientAddress() {
        return properties.getProperty("client_address");
    }

    public int getServerPort() {
        return Integer.parseInt(properties.getProperty("server_port"));
    }

    public int getClientPort() {
        return Integer.parseInt(properties.getProperty("client_port"));
    }
}

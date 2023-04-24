package Spring.lesson4.Task1.Connect;

import java.io.*;
import java.util.Properties;

public class Connector {
    private final Properties properties = new Properties();
    private InputStream in;

    {
        try {
            in = new FileInputStream("C:\\Users\\Вова\\IdeaProjects\\Java_ITVDN\\JavaSpring\\src\\main\\java\\Spring\\lesson4\\Task1\\Connect\\connect.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String url(){
        try {
            properties.load(in);
            return properties.getProperty("URL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String login(){
        try {
            properties.load(in);
            return properties.getProperty("LOGIN");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String password(){
        try {
            properties.load(in);
            return properties.getProperty("PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

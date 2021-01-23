package Tests;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;

public abstract class BaseTestConfiguration {

    static {

        String resourceFolder = "src/main/resources/";
        String defaultConfigPath = resourceFolder + "config.properties";
        try {
            System.getProperties().load(new FileInputStream(defaultConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration.browser = System.getProperty("browser", System.getProperty("defaultBrowser"));
        Configuration.timeout = 180000;
        Configuration.browserSize = "1920x970";
        Configuration.pollingInterval = 200;
        Configuration.baseUrl = "http://www.it-league.lviv.ua";
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
}

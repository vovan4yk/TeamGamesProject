package Tests;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.PropertyConfigurator;

public abstract class BaseTestConfiguration {
    static {
        Configuration.timeout = 180000;
        Configuration.browser = System.getProperty("browser");
        Configuration.browserSize = "1920x970";
        Configuration.pollingInterval = 200;
        Configuration.baseUrl = "http://www.it-league.lviv.ua";
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
}

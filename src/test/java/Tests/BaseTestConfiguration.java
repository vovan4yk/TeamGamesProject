package Tests;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.PropertyConfigurator;
import pageObjects.MyProperties;

public abstract class BaseTestConfiguration {

    static {
        Configuration.browser = MyProperties.getProperty(MyProperties.BROWSER);
        Configuration.timeout = 60000;
        Configuration.browserSize = "1920x970";
        Configuration.pollingInterval = 200;
        Configuration.baseUrl = "http://www.it-league.lviv.ua";
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
}

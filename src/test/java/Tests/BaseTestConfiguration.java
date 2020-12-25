package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import pageObjects.FinalResultTable;

public abstract class BaseTestConfiguration {
    static {
        Configuration.timeout = 9000000;
//        Configuration.browser = WebDriverRunner.CHROME;
//        Configuration.browserSize = "1366x768";
//        Configuration.pollingInterval = 200;
//        Configuration.baseUrl = "http://www.it-league.lviv.ua";
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
}

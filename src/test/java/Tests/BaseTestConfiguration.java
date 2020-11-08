package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

public abstract class BaseTestConfiguration {

    static {
        Configuration.timeout = 6000;
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.browserSize= "1366x768";
        Configuration.pollingInterval = 200;
        Configuration.baseUrl = "http://www.it-league.lviv.ua";
    }
}

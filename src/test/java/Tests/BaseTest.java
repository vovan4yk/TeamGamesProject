package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest extends BaseTestConfiguration {

    public static HomePage homePage;
    public static Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeTest()
    public HomePage login() {
        homePage = open(Configuration.baseUrl, HomePage.class);
        logger.debug("Home page opened");
        return homePage;
    }

    @AfterTest
    public void closeBrowser() {
        closeWebDriver();
    }
}

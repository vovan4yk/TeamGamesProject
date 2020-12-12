package Tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.debug;
import static utils.Log.intLog;

public class BaseTest extends BaseTestConfiguration {

    public static HomePage homePage;

    @BeforeSuite()
    public void initLogger() {
        intLog();
        debug("Logger is ready for using");
    }

    @BeforeTest()
    public HomePage login() {
        homePage = open("http://www.it-league.lviv.ua"/*Configuration.baseUrl*/, HomePage.class);
        debug("Home page opened");
        return homePage;
    }

    @AfterTest
    public void closeBrowser() {
        closeWebDriver();
    }
}

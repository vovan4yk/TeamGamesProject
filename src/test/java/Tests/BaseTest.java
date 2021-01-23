package Tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.getLogger;
import static utils.Log.intLog;

public class BaseTest extends BaseTestConfiguration {

    public static HomePage homePage;
    public static int count = 0;
    public static int maxTries = 10;

    @BeforeSuite()
    public void initLogger() {
        intLog();
        getLogger().debug("Logger is ready for using");
    }

    @AfterTest
    public void closeBrowser() {
        closeWebDriver();
    }
}

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

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
       // System.setProperty("webdriver.chrome.logfile", "C:\\Users\\v.potemskyi\\Desktop\\TeamGamesProject\\src\\main\\resources");
      //  System.setProperty("webdriver.chrome.verboseLogging",  "true");
       // homePage = open("http://www.it-league.lviv.ua"/*Configuration.baseUrl*/, HomePage.class);
      //  open("https://www.google.com.ua/");
        System.out.println("test");
        debug("Home page opened");
        return homePage;
    }

    @AfterTest
    public void closeBrowser() {
        closeWebDriver();
    }
}

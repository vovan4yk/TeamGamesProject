package Tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

   public static HomePage homePage;

    @BeforeTest()
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/travel/TeamGamesProject/chromedriver.exe");
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";
    }

    @BeforeTest()
    public HomePage login(){
        homePage =  open("http://www.it-league.lviv.ua/", HomePage.class);
        getWebDriver().manage().window().maximize();
        return homePage;
    }
}

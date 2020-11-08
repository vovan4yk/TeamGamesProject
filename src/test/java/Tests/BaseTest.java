package Tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest extends BaseTestConfiguration {

    public static HomePage homePage;

    @BeforeTest()
    public HomePage login() {
        homePage = open("/", HomePage.class);
        Selenide.clearBrowserCookies();
        return homePage;
    }

    @AfterTest
    public void closeBrowser() {
        //close browser
    }
}

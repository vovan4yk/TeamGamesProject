package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @FindBy(xpath = "//nav[@class='kopa-main-nav']//ul[contains(@class,'main-menu')]")
    private MainMenu mainMenu;

    private final static Logger logger = Logger.getLogger(HomePage.class);

    private String menuItem = ".//ul[@class='sub-menu']//span[text()='%s']";

    @FindBy(xpath = ".//ul[contains(@class,'main-menu-2')]//a[@href='#']")
    private SelenideElement menu;

    private HomePage selectLeague(String league) {
        menu.shouldBe(Condition.visible).hover();
        $(By.xpath(String.format(menuItem, league))).should(Condition.visible).click();
        return this;
    }

    public HomePage selectItLeague() {
        logger.debug("Selecting league");
        selectLeague("IT-League One 2019/2020");
        return this;
    }

    public Calendar openCalendar() {
        logger.debug("Opening calendar");
        mainMenu.openCalendar();
        return Selenide.page(Calendar.class).waitForDisplayed();
    }

    public PlayedTable openTable() {
        logger.debug("Opening table");
        mainMenu.openTable();
        return Selenide.page(PlayedTable.class).waitForDisplayed();
    }
}

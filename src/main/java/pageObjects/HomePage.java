package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

@FindBy(xpath = "//body[@class='kopa-home-page']")
public class HomePage {

    private MainMenu mainMenu = new MainMenu();
    private GamesTable gamesTable = new GamesTable();

    private String menuItem = ".//ul[@class='sub-menu']//span[text()='%s']";

    @FindBy(xpath = ".//ul[contains(@class,'main-menu-2')]//a[@href='#']")
    private SelenideElement menu;

    private void selectLeague(String league) {
        menu.shouldBe(Condition.visible).hover();
        $(By.xpath(String.format(menuItem, league))).should(Condition.visible).click();
    }

    public void selectItLeague() {
        selectLeague("IT-League One 2019/2020");
    }

    public void openCalendar() {
        mainMenu.openCalendar();
        gamesTable.waitForDisplayed();
    }

    public void openStage(AvailableStage stage) {
        gamesTable.openStage(stage);
    }

    public void openGames(AvailableGames games) {
        gamesTable.openGames(games);
    }

    public void waitPlayedTableDisplayed() {
        gamesTable.getPlayedTable().waitForDisplayed();
    }
}

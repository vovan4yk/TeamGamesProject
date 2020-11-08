package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

@FindBy(xpath = "//div[@class='kopa-main-col']")
public class Calendar extends ElementsContainer {

    @FindBy(xpath = ".//div[contains(@class,'tab-content')]")
    private PlayedTable playedTable;

    public PlayedTable getPlayedTable(int expectedGames) {
        $$(By.xpath("//div[@class='r-item']")).shouldHave(CollectionCondition.sizeGreaterThan(expectedGames));
        return page(PlayedTable.class);
    }
    private final String STAGE = "//p[text()='%s']";
    private final String GAMES = "//a[text()='%s'] | //p[text()='%s']";

    private SelenideElement stagesDropDown = $(By.xpath(".//ul[@class='stage-filter']/parent::div"));
    private SelenideElement PlayedDropDown = $(By.xpath(".//ul[@class='played-filter']/parent::div"));

    Calendar() {
        setSelf($(By.xpath("//div[@class='kopa-main-col']")));
    }

    public Calendar waitForDisplayed() {
        getSelf().shouldBe(Condition.visible);
        return this;
    }

    @Override
    public SelenideElement getSelf() {
        return super.getSelf();
    }

//    public HomePage openStage(AvailableStage stage) {
//        gamesTable.openStage(stage);
//        return this;
//    }
//
//    public HomePage openGames(AvailableGames games) {
//        gamesTable.openGames(games);
//        return this;
//    }
//
//    public HomePage waitPlayedTableDisplayed() {
//        gamesTable.getPlayedTable().waitForDisplayed();
//        return this;
//    }

    public Calendar openStage(AvailableStage stage) {
        stagesDropDown.shouldBe(Condition.visible).click();
        $(By.xpath(String.format(STAGE, stage.getName()))).should(Condition.visible).click();
        return this;
    }

    public Calendar openGames(AvailableGames games) {
        PlayedDropDown.shouldBe(Condition.visible).click();
        String game = games.getName();
        $(By.xpath(String.format(GAMES, game, game))).should(Condition.visible).click();
        return this;
    }

//    public void waitPlayedTableDisplayed() {
//        playedTable.waitForDisplayed();
//    }
}

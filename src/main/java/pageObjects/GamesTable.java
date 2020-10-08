package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GamesTable extends ElementsContainer {

    private PlayedTable playedTable = new PlayedTable();

    public PlayedTable getPlayedTable() {
        return playedTable;
    }

    private final String STAGE = "//p[text()='%s']";
    private final String GAMES = "//a[text()='%s'] | //p[text()='%s']";

    private SelenideElement stagesDropDown = $(By.xpath(".//ul[@class='stage-filter']/parent::div"));
    private SelenideElement PlayedDropDown = $(By.xpath(".//ul[@class='played-filter']/parent::div"));


    GamesTable() {
        setSelf($(By.xpath(".//div[@class='kopa-main-col']")));
    }

    public void waitForDisplayed() {
        getSelf().shouldBe(Condition.visible);
    }

    @Override
    public SelenideElement getSelf() {
        return super.getSelf();
    }

    public void openStage(AvailableStage stage) {
        stagesDropDown.shouldBe(Condition.visible).click();
        $(By.xpath(String.format(STAGE, stage.getName()))).should(Condition.visible).click();
    }

    public void openGames(AvailableGames games) {
        PlayedDropDown.shouldBe(Condition.visible).click();
        String game = games.getName();
        $(By.xpath(String.format(GAMES, game, game))).should(Condition.visible).click();
    }

    public void waitPlayedTableDisplayed() {
        playedTable.waitForDisplayed();
    }
}

package pageObjects;

import businessObjects.TeamGame;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static utils.Log.getLogger;

public class PlayedTable extends ElementsContainer {

    @FindBy(xpath = "//div[@class='kopa-main-col']")
    private FinalResultTable finalResultTable;

    @FindBy(xpath = ".//div[@class='r-item']")
    private List<GameBattle> gamesList;

    public List<GameBattle> getAllGames() {
        getLogger().debug("Getting all games");
        return gamesList.stream()
                .filter(GameBattle::isFirstNameExist)
                .collect(Collectors.toList());
    }

    public PlayedTable waitForDisplayed() {
        $(By.xpath("//div[contains(@class,'tab-content')]")).shouldBe(Condition.visible);
        return this;
    }

    public List<TeamGame> getTableResult() {
        return finalResultTable.getTableResults();
    }
}

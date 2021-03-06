package pageObjects;

import businessObjects.TeamGame;
import businessServices.GameResultAnalyze;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static businessObjects.GameResultValues.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

//@FindBy(xpath = "//div[contains(@class,'tab-content')]")
public class PlayedTable extends ElementsContainer {

    private final String SEPARATOR = "\n";

    @FindBy(xpath = "//div[@class='kopa-main-col']")
    private FinalResultTable finalResultTable;

    private final static Logger logger = Logger.getLogger(PlayedTable.class);

    @FindBy(xpath = ".//div[@class='r-item']")
    private List<GameBattle> gamesList;

    public List<GameBattle> getAllGames() {
        logger.debug("Getting all games");
        return gamesList.stream().filter(game -> game.isFirstNameExist()).collect(Collectors.toList());
    }

    public PlayedTable waitForDisplayed() {
        $(By.xpath("//div[contains(@class,'tab-content')]")).isDisplayed();
        return this;
    }

    public List<TeamGame> getTableResult() {
        return finalResultTable.getTableResults();
    }
}

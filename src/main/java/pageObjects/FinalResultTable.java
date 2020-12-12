package pageObjects;

import businessObjects.TeamGame;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static businessObjects.GameResultValues.*;
import static businessObjects.GameResultValues.PTS;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Log.debug;

public class FinalResultTable extends ElementsContainer {

    private final By teamList = By.xpath(".//li[not(contains(@class,'active'))]");

    @FindBy(xpath = ".//div[contains(@class,'kopa-tab')]")
    private SelenideElement resultTable;

    FinalResultTable() {
        setSelf($(By.xpath("//div[@class='kopa-main-col']")));
    }

    public FinalResultTable waitForDisplayed() {
        getSelf().shouldBe(Condition.visible);
        return this;
    }

    private List<SelenideElement> getTeamGamesList() {
        return resultTable.shouldBe(Condition.visible).$$(teamList);
    }

    private String getValueByHeader(SelenideElement element, String header) {
        return element.$(By.xpath(".//div[" + ($$(By.xpath("//div[@id='tab-2105']//header//div[text()='" + header + "']/preceding-sibling::div")).size() + 1) + "]")).innerText();
    }

    public List<TeamGame> getTableResults() {
        debug("Starting getting results form table");
        List<TeamGame> games = new ArrayList<>();

        getTeamGamesList().forEach(game -> games.add(new TeamGame(getValueByHeader(game, TEAM.getValue()),
                Integer.parseInt(getValueByHeader(game, P.getValue())),
                Integer.parseInt(getValueByHeader(game, W.getValue())),
                Integer.parseInt(getValueByHeader(game, D.getValue())),
                Integer.parseInt(getValueByHeader(game, L.getValue())),
                Integer.parseInt(getValueByHeader(game, F.getValue())),
                Integer.parseInt(getValueByHeader(game, A.getValue())),
                Integer.parseInt(getValueByHeader(game, DIF.getValue())),
                Integer.parseInt(getValueByHeader(game, PTS.getValue()))
        )));
        debug("Results form table was got successfully");
        return games;
    }

    @Override
    public SelenideElement getSelf() {
        return super.getSelf();
    }
}

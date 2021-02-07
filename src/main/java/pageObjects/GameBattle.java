package pageObjects;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//div[@class='r-item']")
public class GameBattle extends ElementsContainer {

    @FindBy(xpath = ".//a[@data-placement='right']")
    private SelenideElement firstTeamName;

    @FindBy(xpath = ".//a[@class='r-num-big']/span")
    private SelenideElement teamsGoals;

    @FindBy(xpath = ".//a[@data-placement='left']")
    private SelenideElement secondTeamName;

    public boolean isFirstNameExist() {
        return firstTeamName.exists();
    }

    public String getFirstTeamName() {
        return firstTeamName.innerText();
    }

    public String getTeamsGoals() {
        return teamsGoals.innerText();
    }

    public String getSecondTeamName() {
        return secondTeamName.innerText();
    }

    @Override
    public String toString() {
        return String.format("Team 1 - %s  %s  -  %s - Team 2" ,
                this.getFirstTeamName(), this.getTeamsGoals(), this.getSecondTeamName());
    }
}

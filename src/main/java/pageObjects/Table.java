package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

//@FindBy(xpath = "//div[@class='kopa-main-col']")
public class Table extends ElementsContainer {

    @FindBy(xpath = ".//div[contains(@class,'kopa-tab')]")
    private SelenideElement resultTable;

    Table() {
        setSelf($(By.xpath("//div[@class='kopa-main-col']")));
    }

    public Table waitForDisplayed() {
        getSelf().shouldBe(Condition.visible);
        return this;
    }

    public TeamGameGame getTableResults(){
    List<SelenideElement> resultList =
        resultTable.shouldBe(Condition.visible).$$(By.xpath(".//li[not(contains(@class,'active'))]"));
         //resultTable;


         return new GameResultAnalyze().analyzeGameResults(resultList);

    }

    @Override
    public SelenideElement getSelf() {
        return super.getSelf();
    }


//    public void waitPlayedTableDisplayed() {
//        playedTable.waitForDisplayed();
//    }
}

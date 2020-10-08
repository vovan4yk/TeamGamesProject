package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PlayedTable extends ElementsContainer {

    PlayedTable(){
        setSelf($(By.xpath(".//div[contains(@class,'tab-content')]")));
    }

    public void waitForDisplayed(){
        getSelf().shouldBe(Condition.visible);
    }
}

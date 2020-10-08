package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainMenu extends ElementsContainer {

    private SelenideElement calendar = $(By.xpath(".//span[text()='Calendar']"));

    MainMenu(){
        setSelf($(By.xpath("//nav[@class='kopa-main-nav']//ul[contains(@class,'main-menu')]")));
    }

    public void openCalendar(){
        calendar.shouldBe(Condition.visible).click();
    }
}

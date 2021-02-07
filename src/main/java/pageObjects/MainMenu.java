package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MainMenu extends ElementsContainer {

    private final String CALENDAR = "Calendar";
    private final String TABLE = "Table";

    @FindBy(xpath = ".//span[text()='Calendar']")
    private SelenideElement calendar;

    MainMenu() {
    }

    public void openCalendar() {
        openMenuTab(CALENDAR);
    }

    public void openTable() {
        openMenuTab(TABLE);
    }

    private void openMenuTab(String tabName) {
        $(By.xpath(String.format("//span[text()='%s']" , tabName))).shouldBe(Condition.visible).click();
    }
}

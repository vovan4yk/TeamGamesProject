package pageObjects;

import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//div[contains(@class,'kopa-tab')]")
public class TableResult extends ElementsContainer {

    TableResult(){
    }

}

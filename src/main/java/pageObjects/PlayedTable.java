package pageObjects;

import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@FindBy(xpath = "//div[contains(@class,'tab-content')]")
public class PlayedTable extends ElementsContainer {

    private final String SEPARATOR = "\n";

    @FindBy(xpath = ".//div[@class='r-item']")
    private List<GameBattle> gamesList;
//init all page as selenide page
   // Collection<GameBattle> list = $$(By.xpath("//div[@class='r-item']"));



    public List<GameBattle> getAllGames(){
       return gamesList.stream().filter(game-> game.isFirstNameExist()).collect(Collectors.toList());
    }

//    PlayedTable(){
//        setSelf($(By.xpath(".//div[contains(@class,'tab-content')]")));
//    }

    //public void waitForDisplayed(){
//        getSelf().shouldBe(Condition.visible);
//    }
}

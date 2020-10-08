package Tests;

import org.testng.annotations.Test;
import pageObjects.AvailableGames;
import pageObjects.AvailableStage;

public class GamesResultsTest extends BaseTest {

    @Test()
    public void myTest()
    {
        homePage.selectItLeague();
        homePage.openCalendar();
        homePage.openStage(AvailableStage.GROUP_STAGE);
        homePage.openGames(AvailableGames.PLAYED);
        homePage.waitPlayedTableDisplayed();
    }

}

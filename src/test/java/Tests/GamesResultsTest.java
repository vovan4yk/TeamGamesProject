package Tests;

import businessObjects.TeamGame;
import businessObjects.Verification;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import businessObjects.AvailableGames;
import businessObjects.AvailableStage;
import pageObjects.GameBattle;
import businessServices.GameResultAnalyze;

import java.util.List;

public class GamesResultsTest extends BaseTest {
    @Test()
    public void myTest() {
        System.out.println(System.getProperty("browser",System.getProperty("defaultBrowser")));
               System.out.println(AvailableStage.valueFromSting(System.getProperty("stages",System.getProperty("defaultStage"))));//add configuration file with param
        System.out.println(AvailableGames.valueFromSting(System.getProperty("games",System.getProperty("defaultGames"))));

    }
}


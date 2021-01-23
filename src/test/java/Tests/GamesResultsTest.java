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

import static utils.Log.getLogger;

public class GamesResultsTest extends BaseTest {
    @Test()
    public void myTest() {
        getLogger().debug(System.getProperty("browser",System.getProperty("defaultBrowser")));
        getLogger().debug(AvailableStage.valueFromSting(System.getProperty("stages",System.getProperty("defaultStage"))));//add configuration file with param
        getLogger().debug(AvailableGames.valueFromSting(System.getProperty("games",System.getProperty("defaultGames"))));

    }
}


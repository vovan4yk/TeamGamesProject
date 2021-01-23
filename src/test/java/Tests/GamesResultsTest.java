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
        List<GameBattle> gameBattleList = homePage.selectItLeague()
                .openCalendar()
               .openStage(AvailableStage.valueFromSting(System.getProperty("stages",System.getProperty("defaultStage"))))//add configuration file with param
                .openGames(AvailableGames.valueFromSting(System.getProperty("games",System.getProperty("defaultGames"))))
                .getPlayedTable(45)
                .getAllGames();

        List<TeamGame> teamGamesFromCalendar = new GameResultAnalyze()
                .analyzeGame(gameBattleList);

        List<TeamGame> teamGamesFromTable = homePage.openTable()
                .getTableResult();

        new Verification().verifyTableAreTheSame(teamGamesFromCalendar, teamGamesFromTable);
    }
}


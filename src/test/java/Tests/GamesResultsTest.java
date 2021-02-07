package Tests;

import businessObjects.TeamGame;
import businessObjects.Verification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import businessObjects.AvailableGames;
import businessObjects.AvailableStage;
import pageObjects.GameBattle;
import businessServices.GameResultAnalyze;
import pageObjects.MyProperties;

import java.util.List;

public class GamesResultsTest extends BaseTest {

    @Test(retryAnalyzer = TestRetryAnalyzer.class, dataProvider = "Stage and game")
    public void myTest(AvailableStage stage, AvailableGames game) {
        List<GameBattle> gameBattleList = homePage.selectItLeague()
                .openCalendar()
                .openStage(stage)
                .openGames(game)
                .getPlayedTable(45)
                .getAllGames();

        List<TeamGame> teamGamesFromCalendar = new GameResultAnalyze()
                .analyzeGame(gameBattleList);

        List<TeamGame> teamGamesFromTable = homePage.openTable()
                .getTableResult();

        new Verification().verifyTableAreTheSame(teamGamesFromCalendar, teamGamesFromTable);
    }

    @DataProvider(name = "Stage and game")
    public static Object[][] stageAndGame() {
        return new Object[][]{
                {AvailableStage.valueFromSting(MyProperties.getProperty(MyProperties.STAGE)),
                        AvailableGames.valueFromSting(MyProperties.getProperty(MyProperties.GAMES))}
        };
    }
}


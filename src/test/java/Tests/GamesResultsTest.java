package Tests;

import businessObjects.TeamGame;
import businessObjects.Verification;
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
                .openStage(AvailableStage.GROUP_STAGE)
                .openGames(AvailableGames.PLAYED)
                .getPlayedTable(45)
                .getAllGames();

        List<TeamGame> teamGamesFromCalendar = new GameResultAnalyze()
                .analyzeGame(gameBattleList);

        List<TeamGame> teamGamesFromTable = homePage.openTable()
                .getTableResult();

        new Verification().verifyTableAreTheSame(teamGamesFromCalendar, teamGamesFromTable);
    }
}


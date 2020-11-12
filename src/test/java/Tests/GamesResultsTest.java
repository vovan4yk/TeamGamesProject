package Tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pageObjects.AvailableGames;
import pageObjects.AvailableStage;
import pageObjects.GameBattle;
import pageObjects.GameResultAnalyze;

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
  
        List<GameResultAnalyze.TeamGame> teamGames = new GameResultAnalyze()
                .analyzeGame(gameBattleList);
 
        GameResultAnalyze gameResultAnalyze = homePage.openTable()
                .gettableResults();

        SoftAssertions.assertSoftly();
    }
}

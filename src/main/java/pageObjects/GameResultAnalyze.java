package pageObjects;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class GameResultAnalyze {

    private List<TeamGame> list = new ArrayList();

    public static class TeamGame {

        public TeamGame(String name) {
            this.team = name;
        }

        private String team;
        private int playedPage;
        private int winGame;
        private int lostGame;
        private int drawGame;
        private int goalsDone;
        private int goalsLost;
        private int gotStage;
        private int goalsDifference;
    }

    public GameResultAnalyze() {
    }

    public List<TeamGame> analyzeGame(List<GameBattle> gameBattleList) {
        //add logger
        gameBattleList.forEach(gameBattle -> {
            if (list.stream().noneMatch(game -> game.team.equals(gameBattle.getFirstTeamName()))) {
                list.add(new TeamGame(gameBattle.getFirstTeamName()));
            }
            if (list.stream().noneMatch(game -> game.team.equals(gameBattle.getSecondTeamName()))) {
                list.add(new TeamGame(gameBattle.getSecondTeamName()));
            }

            String[] goals = gameBattle.getTeamsGoals().split("-");
            int firstTeamGoals = Integer.parseInt(goals[0].trim());
            int secondTeamGoals = Integer.parseInt(goals[1].trim());

            TeamGame team1 = list.stream().filter(team -> team.team.equals(gameBattle.getFirstTeamName()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Team 1 cannot be catch from list for analyzing"));

            TeamGame team2 = list.stream().filter(team -> team.team.equals(gameBattle.getSecondTeamName()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Team 2 cannot be catch from list for analyzing"));

            team1.playedPage++;
            team2.playedPage++;
            team1.goalsDone += firstTeamGoals;
            team2.goalsDone += secondTeamGoals;
            team1.goalsLost += secondTeamGoals;
            team2.goalsLost += firstTeamGoals;

            team1.goalsDifference = team1.goalsDone-team1.goalsLost;
            team2.goalsDifference = team2.goalsDone-team2.goalsLost;

            if (firstTeamGoals > secondTeamGoals) {
                team1.winGame++;
                team1.gotStage += 3;
                team2.lostGame++;
            } else if (firstTeamGoals < secondTeamGoals) {
                team2.winGame++;
                team2.gotStage += 3;
                team1.lostGame++;
            } else {
                team1.drawGame++;
                team2.drawGame++;
                team1.gotStage++;
                team2.gotStage++;
            }
        });
        return list;
    }

    public GameResultAnalyze analyzeGameResults(List<SelenideElement> gameBattleList) {
        gameBattleList.forEach(game->{
               // String[] gameResults =game.getText().split("\n");
           // gameResults
        });
        return null;
    }
}

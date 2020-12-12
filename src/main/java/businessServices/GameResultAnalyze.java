package businessServices;

import businessObjects.TeamGame;
import pageObjects.GameBattle;

import java.util.ArrayList;
import java.util.List;

import static utils.Log.debug;

public class GameResultAnalyze {

    private List<TeamGame> list = new ArrayList();

    public GameResultAnalyze() {
    }

    public List<TeamGame> analyzeGame(List<GameBattle> gameBattleList) {
        debug("Starting process getting team games results");
        gameBattleList.forEach(gameBattle -> {
            debug("Start analyzing game: " + gameBattle.toString());
            if (list.stream().noneMatch(game -> game.getTeam().equals(gameBattle.getFirstTeamName()))) {
                list.add(new TeamGame(gameBattle.getFirstTeamName()));
                debug("New team was added with name - " + gameBattle.getFirstTeamName());
            }
            if (list.stream().noneMatch(game -> game.getTeam().equals(gameBattle.getSecondTeamName()))) {
                list.add(new TeamGame(gameBattle.getSecondTeamName()));
                debug("New team was added with name - " + gameBattle.getSecondTeamName());
            }

            debug("Getting teams goals - " + gameBattle.getTeamsGoals());
            String[] goals = gameBattle.getTeamsGoals().split("-");
            int firstTeamGoals = Integer.parseInt(goals[0].trim());
            int secondTeamGoals = Integer.parseInt(goals[1].trim());

            TeamGame team1 = list.stream().filter(team -> team.getTeam().equals(gameBattle.getFirstTeamName()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Team 1 cannot be catch from list for analyzing"));

            TeamGame team2 = list.stream().filter(team -> team.getTeam().equals(gameBattle.getSecondTeamName()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Team 2 cannot be catch from list for analyzing"));

            debug("Adding teams results...");
            team1.setPlayedGame(team1.getPlayedGame() + 1);
            team2.setPlayedGame(team2.getPlayedGame() + 1);
            team1.setGoalsDone(team1.getGoalsDone() + firstTeamGoals);
            team2.setGoalsDone(team2.getGoalsDone() + secondTeamGoals);
            team1.setGoalsLost(team1.getGoalsLost() + secondTeamGoals);
            team2.setGoalsLost(team2.getGoalsLost() + firstTeamGoals);

            if (firstTeamGoals > secondTeamGoals) {
                team1.setWinGame(team1.getWinGame() + 1);
                team1.setGotStage(team1.getGotStage() + 3);
                team2.setLostGame(team2.getLostGame() + 1);
            } else if (firstTeamGoals < secondTeamGoals) {
                team2.setWinGame(team2.getWinGame() + 1);
                team2.setGotStage(team2.getGotStage() + 3);
                team1.setLostGame(team1.getLostGame() + 1);
            } else {
                team1.setDrawGame(team1.getDrawGame() + 1);
                team2.setDrawGame(team2.getDrawGame() + 1);
                team1.setGotStage(team1.getGotStage() + 1);
                team2.setGotStage(team2.getGotStage() + 1);
            }

            team1.setGoalsDifference(team1.getGoalsDone() - team1.getGoalsLost());
            team2.setGoalsDifference(team2.getGoalsDone() - team2.getGoalsLost());

            debug("Analyzing game: " + gameBattle.toString() + " successfully finished");
        });
        debug("Results got successfully");
        return list;
    }
}

package businessObjects;

public class TeamGame {

    private String team;
    private int playedGame;
    private int winGame;
    private int lostGame;
    private int drawGame;
    private int goalsDone;
    private int goalsLost;
    private int gotStage;
    private int goalsDifference;

    public TeamGame(String team) {
        this.team = team;
    }

    public TeamGame(String team, int played, int win, int draw, int lost, int goalsDone, int goalsLost, int goalsDifference, int gotStage) {
        this.team = team;
        this.playedGame = played;
        this.winGame = win;
        this.drawGame = draw;
        this.lostGame = lost;
        this.goalsDone = goalsDone;
        this.goalsLost = goalsLost;
        this.goalsDifference = goalsDifference;
        this.gotStage = gotStage;
    }

    public String getTeam() {
        return team;
    }

    public int getWinGame() {
        return winGame;
    }

    public int getLostGame() {
        return lostGame;
    }

    public int getDrawGame() {
        return drawGame;
    }

    public int getGoalsDone() {
        return goalsDone;
    }

    public int getGoalsLost() {
        return goalsLost;
    }

    public int getGotStage() {
        return gotStage;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public int getPlayedGame() {
        return playedGame;
    }

    public void setPlayedGame(int playedGame) {
        this.playedGame = playedGame;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setWinGame(int winGame) {
        this.winGame = winGame;
    }

    public void setLostGame(int lostGame) {
        this.lostGame = lostGame;
    }

    public void setDrawGame(int drawGame) {
        this.drawGame = drawGame;
    }

    public void setGoalsDone(int goalsDone) {
        this.goalsDone = goalsDone;
    }

    public void setGoalsLost(int goalsLost) {
        this.goalsLost = goalsLost;
    }

    public void setGotStage(int gotStage) {
        this.gotStage = gotStage;
    }

    public void setGoalsDifference(int goalsDifference) {
        this.goalsDifference = goalsDifference;
    }

    @Override
    public String toString() {
        return String.format("TEAM - %s, P - %s , W - %s, D - %s, L - %s, F - %s, A - %s, +/- - %s, PTS - %s" ,
                this.team, this.playedGame, this.winGame, this.drawGame, this.lostGame, this.goalsDone, this.goalsLost, this.goalsDifference, this.gotStage);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TeamGame)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members
        TeamGame c = (TeamGame) o;
        return this.team.equals(c.team) &&
                this.playedGame == c.playedGame &&
                this.winGame == c.winGame &&
                this.lostGame == c.lostGame &&
                this.drawGame == c.drawGame &&
                this.goalsDone == c.goalsDone &&
                this.goalsLost == c.goalsLost &&
                this.gotStage == c.gotStage &&
                this.goalsDifference == c.goalsDifference;
    }
}

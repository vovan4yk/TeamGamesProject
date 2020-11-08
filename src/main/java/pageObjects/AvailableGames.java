package pageObjects;

public enum AvailableGames {

    ALL_GAME("All games"),
    PLAYED("Played"),
    FUTURE("Future");

    private String name;

    AvailableGames(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

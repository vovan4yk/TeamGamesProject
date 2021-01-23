package businessObjects;

import java.util.Arrays;

public enum AvailableGames {

    ALL_GAME("All games"),
    PLAYED("Played"),
    FUTURE("Future");

    private String name;

    AvailableGames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AvailableGames valueFromSting(String game) {
        return Arrays.stream(values())
                .filter(value -> value.getName().equals(game))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found value with name " + game));
    }
}

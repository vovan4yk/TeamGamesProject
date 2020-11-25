package businessObjects;

public enum GameResultValues {

    TEAM("TEAM"),
    PTS("PTS"),
    DIF("+/-"),
    A("A"),
    F("F"),
    L("L"),
    D("D"),
    W("W"),
    P("P");

    private String value;

    GameResultValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

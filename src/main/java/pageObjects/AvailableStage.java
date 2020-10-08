package pageObjects;

public enum AvailableStage {

    ALL_STAGES("All stages"),
    FINAL("Final"),
    GROUP_STAGE("Group Stage");

    private String name;

    AvailableStage(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

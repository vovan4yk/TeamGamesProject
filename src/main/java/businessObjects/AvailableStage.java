package businessObjects;

import java.util.Arrays;

public enum AvailableStage {

    ALL_STAGES("All stages"),
    FINAL("Final"),
    GROUP_STAGE("Group Stage");

    private String name;

    AvailableStage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AvailableStage valueFromSting(String stage) {
        return Arrays.stream(values())
                .filter(value -> value.getName().equals(stage))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found value with name " + stage));
    }
}

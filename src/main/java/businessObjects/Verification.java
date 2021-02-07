package businessObjects;

import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class Verification {

    public Verification(){
    }

    public void verifyTableAreTheSame(List<TeamGame>teamGamesFromCalendar,List<TeamGame>teamGamesFromTable){
        SoftAssertions.assertSoftly(softly -> softly.assertThat(teamGamesFromCalendar)
                .as("Tables are not equals")
                .containsExactlyInAnyOrderElementsOf(teamGamesFromTable));
    }
}

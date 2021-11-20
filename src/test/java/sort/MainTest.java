import org.junit.jupiter.api.*;
import sort.Main;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class TestMain {

    static List<Integer> team;

    @BeforeEach
    public void startTest(){
        System.out.println("Начало теста");
    }

    @Test
    public void testNational_team_sort() {
        List<Integer> team1 = Arrays.asList(45, 31, 24, 22, 20, 17, 14, 13, 12, 10);
        List<Integer> team2 = Arrays.asList(31, 18, 15, 12, 10, 8, 6, 4, 2, 1);
        List<Integer> team3 = Arrays.asList(51, 30, 10, 9, 8, 7, 6, 5, 2, 1);

        List regional_teams = Arrays.asList(team1, team2, team3);
        team = Main.national_team(regional_teams).subList(0,10);
        assertThat(team, contains(51, 45, 31, 31, 30, 24, 22, 20, 18, 17));
    }

    @AfterEach
    public void endTest(){
        System.out.println("Конец теста");
    }

}

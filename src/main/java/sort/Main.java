package sort;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // 1. Создайте массив региональных команд, в котором будут храниться команды
        List<Integer> team1 = Arrays.asList(45, 31, 24, 22, 20, 17, 14, 13, 12, 10);
        List<Integer> team2 = Arrays.asList(31, 18, 15, 12, 10, 8, 6, 4, 2, 1);
        List<Integer> team3 = Arrays.asList(51, 30, 10, 9, 8, 7, 6, 5, 2, 1);

        List regional_teams = Arrays.asList(team1, team2, team3);

        // 4. Запустите метод выбора национальной команды на примере и выведите на экран
        List<Integer> team = national_team(regional_teams);
        team.stream().limit(10).forEach(System.out::print);
    }

    // 3. Напишите метод для выбора национальной команды из массива региональных команд.
    public static List national_team(List<List<Integer>> regional_teams) {
        int[] team = regional_teams.get(0).stream().mapToInt(Integer::intValue).toArray();
        for (int i = 1; i < regional_teams.size(); i++) {
            int[] regional_team = regional_teams.get(i).stream().mapToInt(Integer::intValue).toArray();
            team = merge(team, regional_team);
        }
        return Arrays.stream(team).boxed().collect(Collectors.toList());
    }

    // 2. Напишите метод слияния команд для выбора топ-10 из обеих команд
    public static int[] merge(int[] team, int[] regional_teams) {

        int[] national_team = new int[team.length + regional_teams.length];
        int ia = 0, ib = 0, ic = 0;

        while (ia < team.length || ib < regional_teams.length) {
            if (ia == team.length) {
                national_team[ic] = regional_teams[ib];
                ib += 1;
            } else if (ib == regional_teams.length) {
                national_team[ic] = team[ia];
                ia += 1;
            } else if (team[ia] >= regional_teams[ib]) {
                national_team[ic] = team[ia];
                ia += 1;
            } else {
                national_team[ic] = regional_teams[ib];
                ib += 1;
            }
            ic += 1;
        }
        return national_team;
    }

}

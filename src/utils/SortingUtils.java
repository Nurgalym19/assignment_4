
package utils;

import model.Player;

import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    public static void sortPlayersByAge(List<Player> players) {
        players.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
    }

    public static void sortPlayersByName(List<Player> players) {
        players.sort(Comparator.comparing(Player::getName));
    }
}


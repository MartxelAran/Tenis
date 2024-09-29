package View;

import Model.Match;
import Model.Player;
import Model.Set;

import java.util.ArrayList;
import java.util.Map;

public class MatchRenderer {

    private Map<Player, Integer> wonGamesByPlayers;
    private ArrayList<Set> sets;
    private ArrayList<Player> players;

    public void showMatch(Match match) {
        players = match.getPlayers();
        sets = match.getSets();
        int setCount = match.getSetNumber();

        for (Player player : players) {
            displayPlayerStats(match, player, setCount);
        }
        System.out.println();
    }

    private void displayPlayerStats(Match match, Player player, int setCount) {
        System.out.print(player.getName() + ": " + match.getPointsByPlayer(player) + " ");

        for (int j = 0; j < setCount; j++) {
            if (j < sets.size()) {
                wonGamesByPlayers = sets.get(j).getWonGamesByPlayers();
                System.out.print(wonGamesByPlayers.get(player) + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }
}

package View;

import Model.Match;
import Model.Player;
import Model.Set;
import util.ConsolePrint;

import java.util.ArrayList;
import java.util.Map;

public class MatchRenderer {

    private Map<Player, Integer> wonGamesByPlayers;
    private ArrayList<Set> sets;
    private ArrayList<Player> players;
    private ConsolePrint consolePrint;

    public MatchRenderer() {
        this.consolePrint = ConsolePrint.getInstance();
    }

    public void displayPoint(Player player) {
        consolePrint.println("---------- "+player.getName() + " has made the point ----------");
    }

    public void showMatch(Match match) {
        if(match.hasFinished()){
            consolePrint.println("---------- Match has finished ----------");
        }
        players = match.getPlayers();
        sets = match.getSets();
        int setCount = match.getSetNumber();

        for (Player player : players) {
            displayPlayerStats(match, player, setCount);
        }
        consolePrint.println("----------------------------------------\n");
    }

    private void displayPlayerStats(Match match, Player player, int setCount) {
        if(player.equals(match.getServer()))consolePrint.print("* ");
        consolePrint.println(player.getName() + ":");
        consolePrint.print("\t"+match.getPointsByPlayer(player) + " ");
        for (int j = 0; j < setCount; j++) {
            if (j < sets.size()) {
                wonGamesByPlayers = sets.get(j).getWonGamesByPlayers();
                consolePrint.print(wonGamesByPlayers.get(player) + " ");
            } else {
                consolePrint.print("- ");
            }
        }
        consolePrint.println();
    }
}

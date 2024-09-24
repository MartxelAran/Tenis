package Controller;

import Model.Match;
import Model.Player;

import java.util.ArrayList;

public class MatchController {

    public ArrayList<Match> matches;

    public MatchController() {
        matches = new ArrayList<>();
    }

    public void startMatch(int matchId) {
        System.out.println(matches.get(matchId-1));
    }

    public int addMatch(int sets, ArrayList<Player> players) {
        matches.add(new Match(sets, players, matches.size()+1));
        return matches.size();
    }
}

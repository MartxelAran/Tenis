package Controller;

import Model.Match;
import Model.Player;
import View.MatchRenderer;

import java.util.ArrayList;

public class MatchController {

    public ArrayList<Match> matches;
    public MatchRenderer matchRenderer;
    public MatchGenerator matchGenerator;
    public Match actualMatch;

    public MatchController(MatchRenderer matchRenderer) {
        matches = new ArrayList<>();
        this.matchRenderer = matchRenderer;
        matchGenerator = new MatchGenerator();
    }

    public void startMatch(int matchId) {
        int reps=0;
        do{
            matchRenderer.showMatch(matches.get(matchId-1));
            int idPointPlayer = matchGenerator.generatePointWinner();
            Player p= PlayerController.getPlayerById(idPointPlayer+1);
            matches.get(matchId-1).playerPoint(p);
            reps++;
        }while(!actualMatch.hasFinished());
        matchRenderer.showMatch(matches.get(matchId-1));
    }

    public int addMatch(int sets, ArrayList<Player> players) {
        actualMatch=new Match(sets, players, matches.size()+1);
        matches.add(actualMatch);
        return matches.size();
    }
}

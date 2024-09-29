package Controller;

import Model.Match;
import Model.Player;
import View.MatchRenderer;

import java.util.ArrayList;
import java.util.List;

public class MatchController {

    private final List<Match> matches;
    private final MatchRenderer matchRenderer;
    private final MatchGenerator matchGenerator;
    private Match actualMatch;

    public MatchController(MatchRenderer matchRenderer) {
        matches = new ArrayList<>();
        this.matchRenderer = matchRenderer;
        matchGenerator = new MatchGenerator();
    }

    public void startMatch(int matchId) {
        do{
            try {
                matchRenderer.showMatch(matches.get(matchId-1));
                Player pointPlayer = matchGenerator.generatePointWinner(actualMatch.getPlayers());
                matchRenderer.displayPoint(pointPlayer);
                matches.get(matchId-1).playerPoint(pointPlayer);
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }while(!actualMatch.hasFinished());
        matchRenderer.showMatch(matches.get(matchId-1));
    }

    public int addMatch(int sets, ArrayList<Player> players) {
        actualMatch=new Match(sets, players, matches.size()+1);
        matches.add(actualMatch);
        return matches.size();
    }
}

package Controller;

import Model.Match;
import Model.Player;
import View.MatchRenderer;

import java.util.ArrayList;
import java.util.List;

public class MatchController {

    private static final int MATCH_DISPLAY_DELAY = 1000;

    private final List<Match> matches;
    private final MatchRenderer matchRenderer;
    private final MatchGenerator matchGenerator;

    public MatchController(MatchRenderer matchRenderer) {
        matches = new ArrayList<>();
        this.matchRenderer = matchRenderer;
        matchGenerator = new MatchGenerator();
    }

    public void startMatch(int matchId) {
        Match match = getMatchById(matchId);
        if (match == null) {
            matchRenderer.showError("Match ID " + matchId + " not found.");
            return;
        }

        try {
            playMatch(match);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            matchRenderer.showError("Match interrupted: " + e.getMessage());
        }
        matchRenderer.showMatch(match);
    }

    public int addMatch(int sets, List<Player> players) {
        Match newMatch = new Match(sets, players, matches.size() + 1);
        matches.add(newMatch);
        return matches.size();
    }

    private Match getMatchById(int matchId) {
        if (matchId <= 0 || matchId > matches.size()) {
            return null;
        }
        return matches.get(matchId - 1);
    }

    private void playMatch(Match match) throws InterruptedException {
        do {
            matchRenderer.showMatch(match);
            processPoint(match);
            Thread.sleep(MATCH_DISPLAY_DELAY);
        } while (!match.hasFinished());
    }

    private void processPoint(Match match) {
        Player pointPlayer = matchGenerator.generatePointWinner(match.getPlayers());
        matchRenderer.displayPoint(pointPlayer);
        match.playerPoint(pointPlayer);
    }
}

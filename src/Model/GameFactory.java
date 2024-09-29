package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class GameFactory {

    public Game createGame(Map<Player, Integer> wonGamesByPlayers) {
        List<Player> players = new ArrayList<>(wonGamesByPlayers.keySet());
        
        if (isTieBreakCondition(wonGamesByPlayers)) {
            return new TieBreak(players);
        } else {
            return new StandardGame(players);
        }
    }
    private boolean isTieBreakCondition(Map<Player, Integer> wonGamesByPlayers) {
        int playersWithSixGames = 0;

        for (Map.Entry<Player, Integer> entry : wonGamesByPlayers.entrySet()) {
            int gamesWon = entry.getValue();
            if (gamesWon == 6) {
                playersWithSixGames++;
            }
            if (playersWithSixGames == 2) {
                return true;
            }
        }
        return false;
    }
}
package Model;

import java.util.ArrayList;
import java.util.Map;

public class TieBreak extends GameType{

    public TieBreak(ArrayList<Player> players) {
        super(players);
    }

    @Override
    public boolean gameFinished() {
        for (Map.Entry<Player, Integer> entry : wonPointsByPlayers.entrySet()) {
            int points = entry.getValue();
            if (points>6){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getActualGamePointsByPlayer(Player player) {
        return wonPointsByPlayers.get(player);
    }
}

package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class GameType {
    public Map<Player, Integer> wonPointsByPlayers;

    public GameType(ArrayList<Player> players){
        wonPointsByPlayers = new HashMap<>();
        wonPointsByPlayers.put(players.get(0),0);
        wonPointsByPlayers.put(players.get(1),0);
    }

    public void playerPoint(Player player){
        wonPointsByPlayers.put(player,wonPointsByPlayers.get(player)+1);
    }

    public Player getOpponent(Player player) {
        for (Map.Entry<Player, Integer> entry : wonPointsByPlayers.entrySet()) {
            if (!entry.getKey().equals(player)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public abstract boolean gameFinished();

    public abstract int getActualGamePointsByPlayer(Player player);
}

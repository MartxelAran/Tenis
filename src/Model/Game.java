package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game{

    public Map<Player, Integer> wonPointsByPlayers;

    public Game(ArrayList<Player> players){
        wonPointsByPlayers = new HashMap<>();
        wonPointsByPlayers.put(players.get(0),0);
        wonPointsByPlayers.put(players.get(1),0);
    }

    public void playerPoint(Player player){
        wonPointsByPlayers.put(player,wonPointsByPlayers.get(player)+1);
    }

    public boolean gameFinished() {
        for (Map.Entry<Player, Integer> entry : wonPointsByPlayers.entrySet()) {
            int points = entry.getValue();
            if (points>3){
                return true;
            }
        }
        return false;
    }

    public int getActualGamePointsByPlayer(Player player){
        return Points.getPoints(wonPointsByPlayers.get(player)).getPoints();
    }
}

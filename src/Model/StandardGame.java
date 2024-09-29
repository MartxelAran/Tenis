package Model;

import java.util.ArrayList;
import java.util.Map;

public class StandardGame extends GameType{

    public StandardGame(ArrayList<Player> players) {
        super(players);
    }

    @Override
    public void playerPoint(Player player) {
        int currentPoints = wonPointsByPlayers.getOrDefault(player, 0);
        if (currentPoints == 3) {
            wonPointsByPlayers.put(player, 4);
        } else if (currentPoints == 4) {
            Player opponent = getOpponent(player);
            wonPointsByPlayers.put(opponent, Math.max(wonPointsByPlayers.get(opponent) - 1, 0));
        } else {
            super.playerPoint(player);
        }
    }

    @Override
    public boolean gameFinished() {
        for (Map.Entry<Player, Integer> entry : wonPointsByPlayers.entrySet()) {
            int points = entry.getValue();
            if (points>3){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getActualGamePointsByPlayer(Player player) {
        return Points.getPoints(wonPointsByPlayers.get(player)).getPoints();
    }
}

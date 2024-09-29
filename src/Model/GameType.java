package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class GameType {
    public Map<Player, Integer> wonPointsByPlayers;
    int pointsToWin;
    ServeTurn serveTurn;

    public GameType(ArrayList<Player> players, ServeTurn serveTurn) {
        wonPointsByPlayers = new HashMap<>();
        wonPointsByPlayers.put(players.get(0),0);
        wonPointsByPlayers.put(players.get(1),0);
        this.serveTurn = serveTurn;
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

    public int getPointsDiff(){
        return Math.abs(
                wonPointsByPlayers.values()
                        .stream()
                        .reduce((points1, points2)->points1-points2)
                        .orElse(0)
        );
    }

    public boolean gameFinished() {
        for (Map.Entry<Player, Integer> entry : wonPointsByPlayers.entrySet()) {
            int points = entry.getValue();
            if (points>pointsToWin && getPointsDiff()>=2){
                return true;
            }
        }
        return false;
    }

    public abstract boolean shouldSwitchServer();

    public void setPointsToWin(int pointsToWin) {
        this.pointsToWin = pointsToWin;
    }

    public abstract String getActualGamePointsByPlayer(Player player);
}

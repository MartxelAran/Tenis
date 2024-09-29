package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Game {
    protected Map<Player, Integer> wonPointsByPlayers;
    protected int pointsToWin;
    protected Game(List<Player> players) {
        wonPointsByPlayers = new HashMap<>();
        wonPointsByPlayers.put(players.get(0),0);
        wonPointsByPlayers.put(players.get(1),0);
    }

    public abstract String getActualGamePointsByPlayer(Player player);

    public abstract boolean shouldSwitchServer();

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

    public void setPointsToWin(int pointsToWin) {
        this.pointsToWin = pointsToWin;
    }

}

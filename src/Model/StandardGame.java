package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StandardGame extends GameType{

    public StandardGame(List<Player> players, ServeTurn serveTurn) {
        super(players, serveTurn);
        setPointsToWin(3);
    }

    @Override
    public void playerPoint(Player player) {
        int currentPoints = wonPointsByPlayers.getOrDefault(player, 0);
        Player opponent = getOpponent(player);
        if (currentPoints == 3 && wonPointsByPlayers.get(opponent) == 3) {
            wonPointsByPlayers.put(player, 4);
        } else if (currentPoints == 3 && wonPointsByPlayers.get(opponent) == 4) {
            wonPointsByPlayers.put(opponent, Math.max(wonPointsByPlayers.get(opponent) - 1, 0));
        } else {
            super.playerPoint(player);
        }
    }

    @Override
    public boolean shouldSwitchServer() {
        return gameFinished();
    }

    @Override
    public String getActualGamePointsByPlayer(Player player) {
        return Points.getPoints(wonPointsByPlayers.get(player)).getPoints();
    }
}

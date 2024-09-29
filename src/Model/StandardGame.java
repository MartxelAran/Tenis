package Model;

import java.util.List;

public class StandardGame extends Game {

    public StandardGame(List<Player> players) {
        super(players);
        setPointsToWin(3);
    }

    @Override
    public void playerPoint(Player player) {
        int currentPoints = wonPointsByPlayers.getOrDefault(player, 0);
        int opponentPoints = wonPointsByPlayers.getOrDefault(getOpponent(player), 0);

        if (isDeuce(currentPoints, opponentPoints)) {
            handleDeuce(player, opponentPoints);
        } else {
            super.playerPoint(player);
        }
    }

    private boolean isDeuce(int playerPoints, int opponentPoints) {
        return playerPoints == 3 && opponentPoints >= 3;
    }

    private void handleDeuce(Player player, int opponentPoints) {
        if (opponentPoints == 3) {
            wonPointsByPlayers.put(player, 4);
        } else if (opponentPoints == 4) {
            wonPointsByPlayers.put(getOpponent(player), Math.max(opponentPoints - 1, 0));
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

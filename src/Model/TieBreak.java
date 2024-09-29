package Model;

import java.util.List;

public class TieBreak extends Game {

    public TieBreak(List<Player> players ) {
        super(players);
        setPointsToWin(6);
    }

    @Override
    public boolean shouldSwitchServer() {
        int totalPoints = wonPointsByPlayers.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (totalPoints == 1) {
            return true;
        }
        return totalPoints % 2 != 0;
    }

    @Override
    public String getActualGamePointsByPlayer(Player player) {
        return wonPointsByPlayers.get(player).toString();
    }
}

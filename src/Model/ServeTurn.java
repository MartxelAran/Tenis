package Model;

import java.util.List;

public class ServeTurn {
    private Player server;
    private Player receiver;

    public ServeTurn(List<Player> players) {
        this.server = players.get(0);
        this.receiver = players.get(1);
    }

    public void switchTurn() {
        Player temp = server;
        server = receiver;
        receiver = temp;
    }

    public Player getServer() {
        return server;
    }
}
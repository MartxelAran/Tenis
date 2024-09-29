package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class ServeTurn {
    private Player server;
    private Player receiver;

    public ServeTurn(ArrayList<Player> players) {
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

    public Player getReceiver() {
        return receiver;
    }
}
package Model;

import java.util.ArrayList;
import java.util.Date;

public class Match {
    int id;
    ArrayList<Set> sets;
    ArrayList<Player> players;
    long date;

    public Match(int sets, ArrayList<Player> players, int id) {
        this.sets = new ArrayList<>(sets);
        this.players = players;
        this.id = id;
        this.date = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return  "id:" + id +
                "\ndate:"+ java.time.Instant.ofEpochMilli(date);
    }
}

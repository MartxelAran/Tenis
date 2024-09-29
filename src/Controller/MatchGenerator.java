package Controller;

import Model.Player;

import java.util.List;
import java.util.Random;

public class MatchGenerator {
    private Random rand;
    public MatchGenerator() {
        rand = new Random();
    }

    public Player generatePointWinner(List<Player> players){
        int randomIndex = rand.nextInt(players.size());
        return players.get(randomIndex);
    }
}

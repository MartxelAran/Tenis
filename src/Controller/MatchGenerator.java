package Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.Random;

public class MatchGenerator {
    Random rand;
    public MatchGenerator() {
        rand = new Random();
    }

    public Player generatePointWinner(ArrayList<Player> players){
        int randomIndex = rand.nextInt(players.size());
        return players.get(randomIndex);
    }
}

package Controller;

import java.util.Random;

public class MatchGenerator {
    Random rand;
    public MatchGenerator() {
        rand = new Random();
    }

    public int generatePointWinner(){
        return rand.nextInt(2);
    }
}

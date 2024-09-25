package View;

import Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    Map<Player, ArrayList<Integer>> scores;

    public ScoreBoard() {
        scores = new HashMap<Player, ArrayList<Integer>>();
    }


}

package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Set {
    public ArrayList<Game> games;
    public Map<Player, Integer> wonGamesByPlayers;
    public Game actualGame;

    public Set(ArrayList<Player> players){
        games = new ArrayList<>();
        actualGame=new Game(players);
        games.add(actualGame);
        wonGamesByPlayers = new HashMap<Player, Integer>();
        wonGamesByPlayers.put(players.get(0), 0);
        wonGamesByPlayers.put(players.get(1), 0);
    }

    public Map<Player, Integer> getWonGamesByPlayers(){
        return wonGamesByPlayers;
    }

    public void playerPoint(Player player){
        actualGame.playerPoint(player);
        if(actualGame.gameFinished()){
            playerGame(player);
        }
    }

    public void playerGame(Player player){
        wonGamesByPlayers.put(player, wonGamesByPlayers.get(player)+1);
        newGame();
    }

    public void newGame(){
        ArrayList<Player> players = new ArrayList<>(wonGamesByPlayers.keySet());
        actualGame=new Game(players);
        games.add(actualGame);
    }

    public boolean setFinished(){
        for (Map.Entry<Player, Integer> entry : wonGamesByPlayers.entrySet()) {
            int games = entry.getValue();
            if (games>6){
                return true;
            }
        }
        return false;
    }

    public Game getActualGame(){
        return actualGame;
    }
}

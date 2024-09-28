package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Set {
    public ArrayList<GameType> games;
    public Map<Player, Integer> wonGamesByPlayers;
    public GameType actualGame;

    public Set(ArrayList<Player> players){
        games = new ArrayList<>();
        actualGame=new StandardGame(players);
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
        if (isTieBreakCondition()) {
            actualGame = new TieBreak(players);  // Crear TieBreakGame si se cumple la condición
        } else {
            actualGame = new StandardGame(players);  // Crear StandardGame en caso contrario
        }
        games.add(actualGame);
    }

    private boolean isTieBreakCondition() {
        int playersWithSixGames = 0;

        for (Map.Entry<Player, Integer> entry : wonGamesByPlayers.entrySet()) {
            int gamesWon = entry.getValue();
            if (gamesWon == 6) {
                playersWithSixGames++;
            }
            if (playersWithSixGames == 2) {
                return true;
            }
        }

        return false;
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

    public GameType getActualGame(){
        return actualGame;
    }
}

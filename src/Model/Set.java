package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Set {
    private List<Game> games;
    private Map<Player, Integer> wonGamesByPlayers;
    private Game actualGame;
    private ServeTurn serveTurn;

    public Set(List<Player> players, ServeTurn serveTurn){
        games = new ArrayList<>();
        actualGame=new StandardGame(players, serveTurn);
        this.serveTurn=serveTurn;
        games.add(actualGame);
        wonGamesByPlayers = new HashMap<>();
        wonGamesByPlayers.put(players.get(0), 0);
        wonGamesByPlayers.put(players.get(1), 0);
    }

    public Map<Player, Integer> getWonGamesByPlayers(){
        return wonGamesByPlayers;
    }

    public void playerPoint(Player player){
        actualGame.playerPoint(player);
        if(actualGame.shouldSwitchServer()){
            serveTurn.switchTurn();
        }
        if(actualGame.gameFinished()){
            playerGame(player);
        }
    }

    public void playerGame(Player player){
        wonGamesByPlayers.put(player, wonGamesByPlayers.get(player)+1);
        newGame();
    }

    public void newGame(){
        List<Player> players = new ArrayList<>(wonGamesByPlayers.keySet());
        if (isTieBreakCondition()) {
            actualGame = new TieBreak(players,serveTurn);
        } else {
            actualGame = new StandardGame(players,serveTurn);
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

    public Game getActualGame(){
        return actualGame;
    }
}

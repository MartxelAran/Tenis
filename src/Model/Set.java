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
    private final GameFactory gameFactory;

    public Set(List<Player> players, ServeTurn serveTurn){
        games = new ArrayList<>();
        actualGame=new StandardGame(players);
        this.serveTurn=serveTurn;
        games.add(actualGame);
        wonGamesByPlayers = new HashMap<>();
        wonGamesByPlayers.put(players.get(0), 0);
        wonGamesByPlayers.put(players.get(1), 0);
        this.gameFactory = new GameFactory();
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
        Game gameCreate = gameFactory.createGame(wonGamesByPlayers);
        actualGame = gameCreate;
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

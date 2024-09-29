package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Set {
    private List<Game> games;
    private Map<Player, Integer> wonGamesByPlayers;
    private ServeTurn serveTurn;
    private final GameFactory gameFactory;

    public Set(List<Player> players, ServeTurn serveTurn){
        this.games = new ArrayList<>();
        this.serveTurn = serveTurn;
        this.wonGamesByPlayers = new HashMap<>();
        this.wonGamesByPlayers.put(players.get(0), 0);
        this.wonGamesByPlayers.put(players.get(1), 0);
        this.gameFactory = new GameFactory();
        this.newGame();
    }

    public Map<Player, Integer> getWonGamesByPlayers(){
        return wonGamesByPlayers;
    }

    public void playerPoint(Player player) {
        getActualGame().playerPoint(player);
        if (getActualGame().shouldSwitchServer()) {
            serveTurn.switchTurn();
        }
        if (getActualGame().gameFinished()) {
            playerGame(player);
        }
    }

    public void playerGame(Player player){
        wonGamesByPlayers.put(player, wonGamesByPlayers.get(player)+1);
        newGame();
    }

    public void newGame(){
        Game gameCreate = gameFactory.createGame(wonGamesByPlayers);
        games.add(gameCreate);
    }

    public boolean setFinished(){
        for (Map.Entry<Player, Integer> entry : wonGamesByPlayers.entrySet()) {
            if (entry.getValue()>6){
                return true;
            }
        }
        return false;
    }

    public Game getActualGame(){
        return games.get(games.size() - 1);
    }
}

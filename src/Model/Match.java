package Model;

import java.util.*;

public class Match {

    private int id;
    private List<Set> sets;
    private Map<Player, Integer> wonSetsByPlayer;
    private Set actualSet;
    private int setNumber;
    private ServeTurn serveTurn;

    public Match(int setNumber, List<Player> players, int id) {
        this.id = id;
        this.sets = new ArrayList<>();
        this.wonSetsByPlayer = new HashMap<>();
        this.serveTurn = new ServeTurn(players);
        this.actualSet = new Set(players, serveTurn);
        this.sets.add(actualSet);
        this.wonSetsByPlayer.put(players.get(0), 0);
        this.wonSetsByPlayer.put(players.get(1), 0);
        this.setNumber = setNumber;
    }

    public void playerPoint(Player player) {
        actualSet.playerPoint(player);
        if (actualSet.setFinished()) {
            playerSet(player);
        }
    }

    public void playerSet(Player player) {
        wonSetsByPlayer.put(player, wonSetsByPlayer.get(player) + 1);
        newSet();
    }

    public void newSet() {
        List<Player> players = new ArrayList<>(wonSetsByPlayer.keySet());
        actualSet = new Set(players, serveTurn);
        sets.add(actualSet);
    }

    public boolean hasFinished() {
        for (Map.Entry<Player, Integer> entry : wonSetsByPlayer.entrySet()) {
            if (entry.getValue() >= (this.setNumber / 2 + 1)) {
                return true;
            }
        }
        return false;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(wonSetsByPlayer.keySet());
    }

    public List<Set> getSets() {
        return sets;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public String getPointsByPlayer(Player player) {
        return actualSet.getActualGame().getActualGamePointsByPlayer(player);
    }

    public Player getServer() {
        return serveTurn.getServer();
    }

    public Map<Player, Integer> getFinalScores() {
        return new HashMap<>(wonSetsByPlayer);
    }

    public Optional<Player> getMatchWinner() {
        return wonSetsByPlayer.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= (setNumber / 2 + 1))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    public int getId() {
        return id;
    }
}

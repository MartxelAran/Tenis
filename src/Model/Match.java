package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Match{
    int id;
    ArrayList<Set> sets;
    Map<Player,Integer> wonSetsByPlayer;
    Set actualSet;
    long date;
    int setNumber;

    public Match(int setNumber, ArrayList<Player> players, int id) {
        this.sets = new ArrayList<>();
        this.id = id;
        this.date = System.currentTimeMillis();
        this.wonSetsByPlayer = new HashMap<>();
        this.actualSet = new Set(players);
        this.sets.add(actualSet);
        this.wonSetsByPlayer.put(players.get(0), 0);
        this.wonSetsByPlayer.put(players.get(1), 0);
        this.setNumber = setNumber;
    }

    public void playerPoint(Player player){
        actualSet.playerPoint(player);
        if(actualSet.setFinished()){
            playerSet(player);
        }
    }

    public void playerSet(Player player){
        wonSetsByPlayer.put(player, wonSetsByPlayer.get(player) + 1);
        newSet();
    }

    public void newSet(){
        ArrayList<Player> players = new ArrayList<>(wonSetsByPlayer.keySet());
        actualSet=new Set(players);
        sets.add(actualSet);
    }

    public boolean hasFinished(){
        for (Map.Entry<Player, Integer> entry : wonSetsByPlayer.entrySet()) {
            int sets = entry.getValue();
            if (sets>=(this.setNumber/2+1)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Player> getPlayers(){
        ArrayList<Player> players = new ArrayList<>(wonSetsByPlayer.keySet());
        return players;
    }

    public ArrayList<Set> getSets(){
        return sets;
    }

    public int getSetNumber(){
        return setNumber;
    }

    public int getPointsByPlayer(Player player){
        return actualSet.getActualGame().getActualGamePointsByPlayer(player);
    }
}

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
            newSet();
        }
    }

    public void newSet(){
        ArrayList<Player> players = new ArrayList<>(wonSetsByPlayer.keySet());
        actualSet=new Set(players);
        sets.add(actualSet);
    }

    public boolean hasFinished(){
        for (Map.Entry<Player, Integer> entry : wonSetsByPlayer.entrySet()) {
            int sets = entry.getValue();
            if (sets>(this.setNumber/2+1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String msg= "id:" + id +
                "\ndate:"+ java.time.Instant.ofEpochMilli(date)+
                "\n"+sets.toString();
        return  msg;
    }
}

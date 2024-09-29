package Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerController {
    private List<Player> players;

    public PlayerController(){
        players = new ArrayList<>();
    }

    public void addPlayer(String name){
        this.players.add(new Player(players.size()+1,name));
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public Player getPlayerByName(String name){
        return this.players.stream().
                filter(p -> p.getName().equals(name)).
                findFirst().orElse(null);
    }

    public Optional<Player> getPlayerById(int id){
        return players.stream().
                filter(p->p.getId()==id).
                findFirst();
    }
}

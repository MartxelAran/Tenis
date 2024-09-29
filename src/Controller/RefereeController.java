package Controller;

import Model.Referee;

import java.util.ArrayList;
import java.util.List;

public class RefereeController {

    List<Referee> referees;
    boolean refereeLogged;

    public RefereeController() {
        referees = new ArrayList<>();
        refereeLogged = false;
    }

    public void addReferee(Referee ref) {
        referees.add(ref);
    }

    public List<Referee> getReferees() {
        return this.referees;
    }

    public boolean checkRefereeCredentials(String name, String password){
        return referees.stream().anyMatch(ref ->
                ref.getName().equals(name) &&
                        ref.getPassword().equals(password)
        );
    }

    public boolean getRefereeLogged(){
        return this.refereeLogged;
    }

    public void setRefereeLogged(boolean refereeLogged){
        this.refereeLogged=refereeLogged;
    }
}

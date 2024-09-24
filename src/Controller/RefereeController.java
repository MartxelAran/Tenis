package Controller;

import Model.Referee;

import java.util.ArrayList;

public class RefereeController {

    ArrayList<Referee> referees;
    boolean refereeLogged;

    public RefereeController() {
        referees = new ArrayList<>();
        refereeLogged = false;
    }

    public void addReferee(Referee ref) {
        referees.add(ref);
    }

    public ArrayList<Referee> getReferees() {
        return this.referees;
    }

    public boolean checkRefereeCredentials(String name, String password){
        boolean isValid = referees.stream().anyMatch(ref ->
                ref.getName().equals(name) &&
                        ref.getPassword().equals(password)
        );
        return isValid;
    }

    public boolean getRefereeLogged(){
        return this.refereeLogged;
    }

    public void setRefereeLogged(boolean refereeLogged){
        this.refereeLogged=refereeLogged;
    }
}

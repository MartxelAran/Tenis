package View;

import Controller.MatchController;
import Controller.PlayerController;
import Controller.RefereeController;
import Model.Match;
import Model.Player;
import Model.Referee;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc;
    RefereeController refereeController;
    PlayerController playerController;
    MatchController matchController;

    public Menu(){
        this.sc = new Scanner(System.in);
        refereeController = new RefereeController();
        playerController = new PlayerController();
        matchController = new MatchController(new MatchRenderer());
    }

    public void crearMenu(){
        String opcion="";
        do {
            System.out.println("Que quiere hacer?");
            System.out.println("1. Create referee");
            System.out.println("2. Login referee");
            System.out.println("3. Crear jugadores");
            System.out.println("4. Leer jugadores");
            System.out.println("5. Crear juego");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    createReferee();
                    break;
                case "2":
                    logReferee();
                    break;
                case "3":
                    if(refereeController.getRefereeLogged())createPlayer();
                    else System.out.println("Referee not logged");
                    break;
                case "4":
                    if(refereeController.getRefereeLogged())readPlayers();
                    else System.out.println("Referee not logged");
                    break;
                case "5":
                    if(refereeController.getRefereeLogged())createMatch();
                    else System.out.println("Referee not logged");
                    break;
                default:
                    System.out.println("Programa finalizada");
                    break;
            }
        }while(!opcion.equals(""));
    }

    public void createReferee(){
        System.out.println("Ingrese un nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese un password");
        String password = sc.nextLine();
        Referee ref = new Referee(nombre,password);
        refereeController.addReferee(ref);
    }

    public void logReferee(){
        System.out.println("Ingrese un nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese un password");
        String password = sc.nextLine();
        if(refereeController.checkRefereeCredentials(nombre,password)){
            System.out.println("Referee logged!");
            refereeController.setRefereeLogged(true);
        }
        else{
            System.out.println("Referee not logged!");
        }
    }

    public void createPlayer(){
        System.out.println("Ingrese un nombre");
        String nombre = sc.nextLine();
        playerController.addPlayer(nombre);
    }

    public void readPlayers(){
        System.out.println(playerController.getPlayers());
    }

    public void createMatch(){
        ArrayList<Player> players=new ArrayList<>();
        System.out.println("Sets: ");
        int sets = sc.nextInt();
        if(sets==1||sets==3||sets==5){
            System.out.println("Ids: ");
            int playerToAdd = sc.nextInt();
            Player p = playerController.getPlayerById(playerToAdd);
            if(p==null){
                System.out.println("Error");
            }else{
                players.add(p);
                playerToAdd = sc.nextInt();
                p = playerController.getPlayerById(playerToAdd);
                if(p==null){
                    System.out.println("Error");
                }else{
                    players.add(playerController.getPlayerById(playerToAdd));
                    int createdMatchId=matchController.addMatch(sets,players);
                    matchController.startMatch(createdMatchId);
                }
            }
        }else{
            System.out.println("Error");
        }
    }
}

package View;

import Controller.MatchController;
import Controller.PlayerController;
import Controller.RefereeController;
import util.ConsolePrint;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<Integer, MenuCommand> commands;
    private final RefereeController refereeController;
    private final PlayerController playerController;
    private final MatchController matchController;

    public Menu(){
        this.refereeController = new RefereeController();
        this.playerController = new PlayerController();
        this.matchController = new MatchController(new MatchRenderer());
        this.commands = new HashMap<>();
        commands.put(1, new CreateRefereeCommand(refereeController));
        commands.put(2, new LogRefereeCommand(refereeController));
        commands.put(3, new CreatePlayerCommand(playerController));
        commands.put(4, new ReadPlayersCommand(playerController));
        commands.put(5, new CreateMatchCommand(matchController, playerController));
    }

    public void createMenu(){
        int option;
        ConsolePrint consolePrint = ConsolePrint.getInstance();
        MenuCommand chosenCommand=null;
        do {
            consolePrint.println("::::::: TENIS MATCH :::::::::");
            consolePrint.println("Elija la opcion que desee: ");
            commands.forEach((key, command) -> command.showCommand());
            option = consolePrint.nextInt();
            consolePrint.nextLine();
            chosenCommand = commands.get(option);
            if (chosenCommand != null) {
                chosenCommand.execute();
            } else {
                consolePrint.println("Program ended");
            }
        }while(chosenCommand!=null);
    }
}

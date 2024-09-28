package View;

import Controller.MatchController;
import Controller.PlayerController;
import Controller.RefereeController;
import util.ConsolePrint;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private final Map<String, MenuCommand> commands;
    private final RefereeController refereeController;
    private final PlayerController playerController;
    private final MatchController matchController;

    public Menu() {
        refereeController = new RefereeController();
        playerController = new PlayerController();
        matchController = new MatchController(new MatchRenderer());
        this.commands = new HashMap<>();

        commands.put("1", new CreateRefereeCommand(refereeController));
        commands.put("2", new LogRefereeCommand(refereeController));
        commands.put("3", new CreatePlayerCommand(playerController));
        commands.put("4", new ReadPlayersCommand(playerController));
        commands.put("5", new CreateMatchCommand(matchController, playerController));
    }


    public void crearMenu(){
        String opcion="";
        ConsolePrint consolePrint = ConsolePrint.getInstance();
        do {
            consolePrint.println("Que quiere hacer?");
            consolePrint.println("1. Create referee");
            consolePrint.println("2. Login referee");
            consolePrint.println("3. Crear jugadores");
            consolePrint.println("4. Leer jugadores");
            consolePrint.println("5. Crear juego");
            opcion = consolePrint.nextLine();
            MenuCommand command = commands.get(opcion);
            if (command != null) {
                command.execute();
            } else {
                consolePrint.println("Programa finalizada");
                break;
            }
        }while(!opcion.isEmpty());
    }
}

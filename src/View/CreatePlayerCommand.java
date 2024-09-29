package View;

import Controller.PlayerController;
import util.ConsolePrint;

class CreatePlayerCommand implements MenuCommand {
    public static final String CREATE_PLAYERS_OPTIONS = "3. Create players";
    private final PlayerController playerController;
    private final ConsolePrint consolePrint;

    public CreatePlayerCommand(PlayerController playerController) {
        this.playerController = playerController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println(CREATE_PLAYERS_OPTIONS);
    }

    @Override
    public void execute() {
        String nombre;
        do{
            consolePrint.println("Name of the player (enter to end creating players): ");
            nombre = consolePrint.nextLine();
            if(!nombre.isEmpty()){
                playerController.addPlayer(nombre);
            }
        }while (!nombre.isEmpty());
    }
}
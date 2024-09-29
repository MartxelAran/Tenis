package View;

import Controller.PlayerController;
import util.ConsolePrint;

class CreatePlayerCommand implements MenuCommand {
    private final PlayerController playerController;
    private final ConsolePrint consolePrint;

    public CreatePlayerCommand(PlayerController playerController) {
        this.playerController = playerController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("3. Create players");
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
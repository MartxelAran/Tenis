package View;

import Controller.PlayerController;
import util.ConsolePrint;

class CreatePlayerCommand implements MenuCommand {
    private final PlayerController playerController;

    public CreatePlayerCommand(PlayerController playerController) {
        this.playerController = playerController;
    }

    @Override
    public void execute() {
        ConsolePrint consolePrint = ConsolePrint.getInstance();
        consolePrint.println("Ingrese un nombre");
        String nombre = consolePrint.nextLine();
        playerController.addPlayer(nombre);
    }
}
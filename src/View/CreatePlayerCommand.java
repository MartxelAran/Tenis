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
        consolePrint.println("Ingrese un nombre");
        String nombre = consolePrint.nextLine();
        playerController.addPlayer(nombre);
    }
}
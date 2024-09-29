package View.command;

import Controller.PlayerController;
import util.ConsolePrint;

public class ReadPlayersCommand implements MenuCommand{

    private final PlayerController playerController;
    private final ConsolePrint consolePrint;

    public ReadPlayersCommand(PlayerController playerController) {
        this.playerController = playerController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("4. Read players");
    }

    @Override
    public void execute() {
        consolePrint.println(playerController.getPlayers());
    }
}

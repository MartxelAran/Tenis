package View;

import Controller.PlayerController;
import util.ConsolePrint;

public class ReadPlayersCommand implements MenuCommand{

    private final PlayerController playerController;

    public ReadPlayersCommand(PlayerController playerController) {
        this.playerController = playerController;
    }

    @Override
    public void execute() {
        ConsolePrint.getInstance().println(playerController.getPlayers());
    }
}

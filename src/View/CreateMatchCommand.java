package View;

import Controller.MatchController;
import Controller.PlayerController;
import Model.Player;
import util.ConsolePrint;

import java.util.ArrayList;

public class CreateMatchCommand implements MenuCommand{

    private final MatchController matchController;
    private final PlayerController playerController;

    public CreateMatchCommand(MatchController matchController, PlayerController playerController) {
        this.matchController = matchController;
        this.playerController = playerController;
    }

    @Override
    public void execute() {
        ConsolePrint consolePrint = ConsolePrint.getInstance();
        ArrayList<Player> players = new ArrayList<Player>();
        consolePrint.println("Sets: ");
        int sets = consolePrint.nextInt();
        consolePrint.nextLine(); // Clear buffer
        if (sets == 1 || sets == 3 || sets == 5) {
            consolePrint.println("Ids: ");
            int playerToAdd = consolePrint.nextInt();
            consolePrint.nextLine();
            Player p = playerController.getPlayerById(playerToAdd);
            if (p == null) {
                consolePrint.println("Error: Player not found");
            } else {
                players.add(p);
                playerToAdd = consolePrint.nextInt();
                consolePrint.nextLine();
                p = playerController.getPlayerById(playerToAdd);
                if (p == null) {
                    consolePrint.println("Error: Player not found");
                } else {
                    players.add(playerController.getPlayerById(playerToAdd));
                    int createdMatchId = matchController.addMatch(sets, players);
                    matchController.startMatch(createdMatchId);
                }
            }
        } else {
            consolePrint.println("Error: Invalid number of sets");
        }
    }
}

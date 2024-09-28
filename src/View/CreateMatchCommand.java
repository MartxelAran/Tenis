package View;

import Controller.MatchController;
import Controller.PlayerController;
import Model.Player;
import util.ConsolePrint;

import java.util.ArrayList;

public class CreateMatchCommand implements MenuCommand{

    private final MatchController matchController;
    private final ConsolePrint consolePrint;

    public CreateMatchCommand(MatchController matchController) {
        this.matchController = matchController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("5. Create match");
    }

    @Override
    public void execute() {
        ArrayList<Player> players = new ArrayList<>();

        consolePrint.println("Sets: ");
        int sets = consolePrint.nextInt();
        consolePrint.nextLine();

        if (sets != 1 && sets != 3 && sets != 5) {
            consolePrint.println("Error: Invalid number of sets. Must be 1, 3, or 5.");
            return;
        }

        if (!addPlayers(consolePrint, players)) {
            return;
        }

        int createdMatchId = matchController.addMatch(sets, players);
        matchController.startMatch(createdMatchId);
    }

    private boolean addPlayers(ConsolePrint consolePrint, ArrayList<Player> players) {
        for (int i = 0; i < 2; i++) {
            consolePrint.print("Enter Player " + (i + 1) + " ID: ");
            int playerToAdd = consolePrint.nextInt();
            consolePrint.nextLine();

            Player p = PlayerController.getPlayerById(playerToAdd);
            if (p == null) {
                consolePrint.println("Error: Player with ID " + playerToAdd + " not found.");
                return false;
            }

            players.add(p);
        }

        return true;
    }
}

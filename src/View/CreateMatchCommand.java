package View;

import Controller.MatchController;
import Controller.PlayerController;
import Model.Player;
import util.ConsolePrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateMatchCommand implements MenuCommand {

    private final MatchController matchController;
    private final ConsolePrint consolePrint;
    private final PlayerController playerController;

    public CreateMatchCommand(MatchController matchController, PlayerController playerController) {
        this.matchController = matchController;
        this.playerController = playerController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("5. Create match");
    }

    @Override
    public void execute() {
        List<Player> players = new ArrayList<>();

        int sets = getNumberOfSets();
        if (sets == -1) return;

        if (!collectPlayers(players)) {
            return;
        }

        int createdMatchId = matchController.addMatch(sets, players);
        matchController.startMatch(createdMatchId);
    }

    private int getNumberOfSets() {
        consolePrint.print("Sets (3 o 5): ");
        int sets = consolePrint.nextInt();
        consolePrint.nextLine();

        if (sets != 3 && sets != 5) {
            consolePrint.println("Error: Número de sets inválido. Debe ser 3 o 5.");
            return -1;
        }
        return sets;
    }

    private boolean collectPlayers(List<Player> players) {
        for (int i = 0; i < 2; i++) {
            consolePrint.print("Ingrese el ID del Jugador " + (i + 1) + ": ");
            int playerId = consolePrint.nextInt();
            consolePrint.nextLine();

            Optional<Player> playerOptional = playerController.getPlayerById(playerId);
            if (Boolean.FALSE.equals(playerOptional.isPresent())) {
                consolePrint.println("Error: Jugador con ID " + playerId + " no encontrado.");
                return false;
            }else{
                players.add(playerOptional.get());
            }
        }
        return true;
    }
}

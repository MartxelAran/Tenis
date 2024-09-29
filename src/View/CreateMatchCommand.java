package View;

import Controller.MatchController;
import Controller.PlayerController;
import Model.Player;
import util.ConsolePrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateMatchCommand implements MenuCommand {

    public static final String CREATE_MATCH_OPTION = "5. Create match";
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
        consolePrint.println(CREATE_MATCH_OPTION);
    }

    @Override
    public void execute() {
        int sets = getNumberOfSets();
        if (sets == -1) return;

        List<Player> players = collectPlayers();
        if (players.isEmpty()) {
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

    private List<Player> collectPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            consolePrint.print("Ingrese el ID del Jugador " + (i + 1) + ": ");
            int playerId = consolePrint.nextInt();
            consolePrint.nextLine();

            Optional<Player> playerOptional = playerController.getPlayerById(playerId);
            if (Boolean.FALSE.equals(playerOptional.isPresent())) {
                consolePrint.println("Error: Jugador con ID " + playerId + " no encontrado.");
                return new ArrayList<>();
            }else{
                players.add(playerOptional.get());
            }
        }
        return players;
    }
}

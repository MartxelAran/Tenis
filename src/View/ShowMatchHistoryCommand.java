package View;

import Controller.MatchController;
import Model.Match;
import Model.Player;
import util.ConsolePrint;

import java.util.Map;
import java.util.Optional;

public class ShowMatchHistoryCommand implements MenuCommand{
    private final MatchController matchController;
    private final ConsolePrint consolePrint;

    public ShowMatchHistoryCommand(MatchController matchController) {
        this.matchController = matchController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("6. Show match history");
    }

    @Override
    public void execute() {
        consolePrint.println("Matches played:");
        for (Match match : matchController.getMatches()) {
            consolePrint.println("Match ID: " + match.getId());
            consolePrint.println("Players: " + match.getPlayers());

            Map<Player, Integer> finalScores = match.getFinalScores();
            for (Map.Entry<Player, Integer> entry : finalScores.entrySet()) {
                consolePrint.println("Player: " + entry.getKey().getName() + " - Sets Won: " + entry.getValue());
            }

            Optional<Player> winner = match.getMatchWinner();
            consolePrint.println("Winner: " + (winner.isPresent() ? winner.get().getName() : "Match not finished"));
            consolePrint.println();
        }
    }
}

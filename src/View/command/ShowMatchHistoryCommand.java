package View.command;

import Controller.MatchController;
import Model.Match;
import Model.Player;
import util.ConsolePrint;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShowMatchHistoryCommand implements MenuCommand {
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
        consolePrint.println("Matches played: ____________________");

        for (Match match : matchController.getMatches()) {
            printMatchDetails(match);
            consolePrint.println();
        }
    }

    private void printMatchDetails(Match match) {
        consolePrint.println("Match ID: " + match.getId());
        consolePrint.println("Players: " + formatPlayers(match.getPlayers()));
        printFinalScores(match.getFinalScores());
        printMatchWinner(match.getMatchWinner());
    }

    private String formatPlayers(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
    }

    private void printFinalScores(Map<Player, Integer> finalScores) {
        for (Map.Entry<Player, Integer> entry : finalScores.entrySet()) {
            consolePrint.println("Player: " + entry.getKey().getName() + " - Sets Won: " + entry.getValue());
        }
    }

    private void printMatchWinner(Optional<Player> winner) {
        String winnerName = winner.map(Player::getName).orElse("Match not finished");
        consolePrint.println("Winner: " + winnerName);
    }
}

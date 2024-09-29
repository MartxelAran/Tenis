package View;

import Controller.MatchController;
import Controller.PlayerController;
import Controller.RefereeController;
import util.ConsolePrint;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    public static final String OPTION_NOT_VALID = "Opción no válida. Por favor, intente de nuevo.";
    public static final String TENIS_MATCH_TITLE = "::::::::: TENIS MATCH :::::::::";
    public static final String SELECT_OPTION = "Elija la opción que desee: ";
    private final Map<Integer, MenuCommand> commands;
    private final ConsolePrint consolePrint;

    public Menu() {
        this.consolePrint = ConsolePrint.getInstance();
        this.commands = initializeCommands();
    }

    private Map<Integer, MenuCommand> initializeCommands() {
        Map<Integer, MenuCommand> commands = new HashMap<>();
        RefereeController refereeController = new RefereeController();
        PlayerController playerController = new PlayerController();
        MatchController matchController = new MatchController(new MatchRenderer());

        commands.put(1, new CreateRefereeCommand(refereeController));
        commands.put(2, new LogRefereeCommand(refereeController));
        commands.put(3, new CreatePlayerCommand(playerController));
        commands.put(4, new ReadPlayersCommand(playerController));
        commands.put(5, new CreateMatchCommand(matchController, playerController));
        commands.put(6, new ShowMatchHistoryCommand(matchController));
        return commands;
    }

    public void createMenu() {
        int option;
        MenuCommand menuCommand;
        do {
            displayMenuOptions();
            option = consolePrint.nextInt();
            consolePrint.nextLine();
            menuCommand = commands.get(option);
            executeCommand(menuCommand);
        } while (menuCommand != null);
    }

    private void displayMenuOptions() {
        consolePrint.println(TENIS_MATCH_TITLE);
        consolePrint.println(SELECT_OPTION);
        commands.forEach((key, command) -> command.showCommand());
    }

    private void executeCommand(MenuCommand chosenCommand) {
        if (chosenCommand != null) {
            chosenCommand.execute();
        } else {
            consolePrint.println(OPTION_NOT_VALID);
        }
    }
}

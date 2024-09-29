package View.command;

import Controller.RefereeController;
import util.ConsolePrint;

public class LogRefereeCommand implements MenuCommand {
    private final RefereeController refereeController;
    private final ConsolePrint consolePrint;

    public LogRefereeCommand(RefereeController refereeController) {
        this.refereeController = refereeController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("2. Login referee");
    }

    @Override
    public void execute() {
        consolePrint.println("Enter a name");
        String nombre = consolePrint.nextLine();
        consolePrint.println("Enter a password");
        String password = consolePrint.nextLine();
        if (refereeController.checkRefereeCredentials(nombre, password)) {
            consolePrint.println("Referee logged!");
            refereeController.setRefereeLogged(true);
        } else {
            consolePrint.println("Referee not logged!");
        }
    }
}
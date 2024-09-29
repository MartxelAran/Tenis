package View.command;

import Controller.RefereeController;
import Model.Referee;
import util.ConsolePrint;

public class CreateRefereeCommand implements MenuCommand {
    private final RefereeController refereeController;
    private final ConsolePrint consolePrint;

    public CreateRefereeCommand(RefereeController refereeController) {
        this.refereeController = refereeController;
        this.consolePrint = ConsolePrint.getInstance();
    }

    @Override
    public void showCommand() {
        consolePrint.println("1. Create referee");
    }

    @Override
    public void execute() {
        consolePrint.println("Enter a name");
        String nombre = consolePrint.nextLine();
        consolePrint.println("Enter a password");
        String password = consolePrint.nextLine();
        Referee referee = new Referee(nombre, password);
        refereeController.addReferee(referee);
    }
}

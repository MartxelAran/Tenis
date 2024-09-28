package View;

import Controller.RefereeController;
import util.ConsolePrint;

class LogRefereeCommand implements MenuCommand {
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
        consolePrint.println("Ingrese un nombre");
        String nombre = consolePrint.nextLine();
        consolePrint.println("Ingrese un password");
        String password = consolePrint.nextLine();
        if (refereeController.checkRefereeCredentials(nombre, password)) {
            System.out.println("Referee logged!");
            refereeController.setRefereeLogged(true);
        } else {
            consolePrint.println("Referee not logged!");
        }
    }
}
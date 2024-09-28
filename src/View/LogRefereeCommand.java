package View;

import Controller.RefereeController;
import util.ConsolePrint;

class LogRefereeCommand implements MenuCommand {
    private final RefereeController refereeController;

    public LogRefereeCommand(RefereeController refereeController) {
        this.refereeController = refereeController;
    }

    @Override
    public void execute() {
        ConsolePrint consolePrint = ConsolePrint.getInstance();
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
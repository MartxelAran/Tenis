package View;

import Controller.RefereeController;
import Model.Referee;
import util.ConsolePrint;

public class CreateRefereeCommand implements MenuCommand {
    private RefereeController refereeController;

    public CreateRefereeCommand(RefereeController refereeController) {
        this.refereeController = refereeController;
    }

    @Override
    public void execute() {
        ConsolePrint consolePrint = ConsolePrint.getInstance();
        consolePrint.println("Ingrese un nombre");
        String nombre = consolePrint.nextLine();
        consolePrint.println("Ingrese un password");
        String password = consolePrint.nextLine();
        Referee ref = new Referee(nombre, password);
        refereeController.addReferee(ref);
    }
}

package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsolePrint {

    private static ConsolePrint console = new ConsolePrint();

    private Scanner scanner;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static ConsolePrint getInstance() {
        return console;
    }

    private ConsolePrint() {
         scanner = new Scanner(System.in);
    }

    public String readString(String title) {
        String input = null;
        this.write(title);
        try {
            input = this.bufferedReader.readLine();
        } catch (Exception ex) {
        }
        return input;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.printError("integer");
            }
            assert ok;
        } while (!ok);
        return input;
    }

    public int nextInt(){
        return scanner.nextInt();
    }

    public String nextLine(){
        return scanner.nextLine();
    }

    public void println() {
        System.out.println();
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String string) {
        System.out.print(string);
    }

    public void write(int integer) {
        System.out.print(integer);
    }

    public void write(String integer) {
        System.out.print(integer);
    }

    public void printError(String format) {
        System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
    }

    public <T> void println(ArrayList<T> players) {
        for (T player : players) {
            System.out.println(player.toString());
        }
    }
}

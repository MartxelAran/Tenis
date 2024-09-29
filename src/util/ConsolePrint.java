package util;

import java.util.List;
import java.util.Scanner;

public class ConsolePrint {

    private static ConsolePrint console = new ConsolePrint();

    private Scanner scanner;

    public static ConsolePrint getInstance() {
        return console;
    }

    private ConsolePrint() {
         scanner = new Scanner(System.in);
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

    public <T> void println(List<T> players) {
        for (T player : players) {
            System.out.println(player.toString());
        }
    }
}

package battleship.game;


import java.util.Scanner;

public class GetMove {

    static Scanner scanner = new Scanner(System.in);
    public static String getMove() {
        return scanner.next().toUpperCase(); }

}

package spil;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Tager imod navne inputs, først p1 og derefter p2
        System.out.println("Player 1 name:");
        Player p1 = new Player(scanner.nextLine());

        System.out.println("Player 2 name:");
        Player p2 = new Player(scanner.nextLine());

        Game game = new Game(p1, p2);

        game.play();
    }

}

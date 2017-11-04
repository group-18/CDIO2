package spil;


import desktop_resources.GUI;

public class Main {
    public static void main(String[] args) {
        Board.boardgame();

        //Tager imod navne inputs, først p1 og derefter p2
        Player p1 = new Player(GUI.getUserString("Indtast spiller 1's navn"));
        Player p2 = new Player(GUI.getUserString("Indtast spiller 2's navn"));

        Game game = new Game(p1, p2);

        game.play();
    }
}

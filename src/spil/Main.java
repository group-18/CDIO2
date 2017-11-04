package spil;


public class Main {
    public static void main(String[] args) {
        Board.boardgame();

        Game game = new Game();
        game.askForPlayers(2);
        game.play();
    }
}

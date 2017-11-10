package spil;


public class Main {
    public static void main(String[] args) {
        //The game-object is created
        Game game = new Game();
        //The askForPlayer() can be changed if more players are needed to play the game
        game.askForPlayers(2);
        //the Game-class contains the game, and the the method play() plays it
        game.play();
    }
}
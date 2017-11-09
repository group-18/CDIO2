package spil;


import desktop_resources.*;


public class Game {
    private Dice[] dies;

    private Player[] players;
    private int playerIndex = 0;

    private String[][] fields = new String[][] {
        {"tower", "Tower"},
        {"crater", "Crater"},
        {"palace_gates", "Palace Gates"},
        {"cold_desert", "Cold Desert"},
        {"walled_city", "Walled City"},
        {"monastery", "Monastery"},
        {"black_cave", "Black Cave"},
        {"huts_in_the_mountain", "Huts in the Mountain"},
        {"the_werewall", "The Werewall (werewolf-wall)"},
        {"the_pit", "The Pit"},
        {"goldmine", "Goldmine"},
    };

    private int[] fieldValues = new int[] {
        250,
        -100,
        100,
        -20,
        180,
        0,
        -70,
        60,
        -80,
        -50,
        650,
    };

    public Game()
    {
        this.dies = new Dice[] {new Dice(), new Dice()};
    }

    public void askForPlayers(int numberOfPlayers)
    {
        this.players = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = GUI.getUserString(
                    Translate.t("writeName", new String[] {"" + (i + 1)})
            );

            this.players[i] = new Player(playerName);

            GUI.addPlayer(this.players[i].getName(), this.players[i].getAmount());
        }
    }

    public void play() {
        this.printWelcomeMessage();

        Player currentPlayer;
        boolean winnerFound;

        do {
            currentPlayer = getNextPlayer();

            this.print(Translate.t("turn.currentPlayer", new String[] {currentPlayer.getName()}));
            //Adds a button that executes the following do-while-statement, remove this for easy unittesting
            GUI.getUserButtonPressed("", "Kast");

            do {
                GUI.removeAllCars(currentPlayer.getName());

                this.rollDies();

                GUI.setCar(this.sum(), currentPlayer.getName());
                GUI.setDice(this.dies[0].getFaceValue(), 3, 8, this.dies[1].getFaceValue(), 4, 8);

                int fieldNumber = this.sum() - 2;

                this.print(new String[] {
                        Translate.t("turn.rollResult", new String[] {"" + sum()}),
                        Translate.t("turn.position", new String[] {this.fields[fieldNumber][1]}),
                        Translate.t("field." + this.fields[fieldNumber][0] + ".description"),
                });

                int score = this.fieldValues[fieldNumber];
                currentPlayer.addAmount(score);

                this.print(new String[] {
                    Translate.t("turn.score", new String[] {"" + (score > 0 ? "+" : "") + score}),
                    Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}),
                });

                GUI.setBalance(currentPlayer.getName(),currentPlayer.getAmount());
            } while (this.sum() == 10);

            winnerFound = currentPlayer.getAmount() >= 3000;
        } while (! winnerFound);

        this.printScoreBoard(currentPlayer);
    }

    private Player getNextPlayer()
    {
        if (this.playerIndex >= this.players.length) {
            this.playerIndex = 0;
        }

        return this.players[this.playerIndex++];
    }

    private void printWelcomeMessage(){
        this.print(Translate.t("welcome1"));
        this.print(Translate.t("welcome2"));
        this.print(Translate.t("welcome3"));
    }

    private void printScoreBoard(Player winningPlayer)
    {
        String[] scoreboardText = new String[this.players.length + 2];

        scoreboardText[0] = Translate.t("scoreboard.title");

        for (int i = 1; i <= this.players.length; i++) {
            Player player = this.players[i - 1];

            scoreboardText[i] = " - " + player.getName() + ": " + player.getAmount();

            if (player == winningPlayer) {
                scoreboardText[i] = scoreboardText[i] + " " + Translate.t("scoreboard.winnerText");
            }
        }

        scoreboardText[this.players.length + 1] = Translate.t("scoreboard.winner", new String[] {winningPlayer.getName()});

        this.print(String.join("\n", scoreboardText));
    }


    private int sum()
    {
        int sum = 0;

        for (Dice dice : this.dies) {
            sum += dice.getFaceValue();
        }

        return sum;
    }


    private void rollDies()
    {
        for (Dice dice : this.dies) {
            dice.roll();
        }
    }


    private void print(String msg)
    {
        GUI.showMessage(msg);
    }


    private void print(String[] messages)
    {
        this.print(String.join("\n", messages));
    }

}
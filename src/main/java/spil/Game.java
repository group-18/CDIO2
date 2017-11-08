package spil;


import desktop_resources.*;


public class Game {
    private Player[] players;
    private int playerIndex = 0;
    private Dice[] dies;

    public Game()
    {
     Dice d1 = new Dice(6);
     Dice d2 = new Dice(6);
     this.dies = new Dice[2];
     this.dies[0] = d1;
     this.dies[1] = d2;
    }

    public int sum() {
        return dies[0].getFaceValue()+dies[1].getFaceValue();
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
        boolean winnerFound = false;

        do {

            currentPlayer = getNextPlayer();

            this.print(Translate.t("turn.currentPlayer", new String[] {currentPlayer.getName()}));
            //Adds a button that executes the following do-while-statement, remove this for easy unittesting
            GUI.getUserButtonPressed("", "Kast");

            do {
                GUI.removeAllCars(currentPlayer.getName());
                dies[0].roll();
                dies[1].roll();
                GUI.setDice(dies[0].getFaceValue(),3,8,dies[1].getFaceValue(),4,8);
                int fieldNumber = sum();
                GUI.setCar(fieldNumber, currentPlayer.getName());
                this.print(Translate.t("turn.rollResult", new String[] {"" + sum()}));
                switch (fieldNumber) {
                    case 2:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Tower"}),
                                Translate.t("field.tower.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"+250"}));
                        currentPlayer.addAmount(250);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));

                        break;
                    case 3:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Crater"}),
                                Translate.t("field.crater.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-100"}));
                        currentPlayer.addAmount(-100);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 4:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Palace Gates"}),
                                Translate.t("field.palace_gates.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"100"}));
                        currentPlayer.addAmount(100);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 5:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Cold Desert"}),
                                Translate.t("field.cold_desert.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-20"}));
                        currentPlayer.addAmount(-20);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 6:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Walled City"}),
                                Translate.t("field.walled_city.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"180"}));
                        currentPlayer.addAmount(180);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 7:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Monastery"}),
                                Translate.t("field.monastery.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"0"}));
                        currentPlayer.addAmount(0);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 8:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Black Cave"}),
                                Translate.t("field.black_cave.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-70"}));
                        currentPlayer.addAmount(-70);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 9:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Huts in the Mountain"}),
                                Translate.t("field.huts_in_the_mountain.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"60"}));
                        currentPlayer.addAmount(60);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 10:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"The Werewall (werewolf-wall)"}),
                                Translate.t("field.the_werewall.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-80"}));
                        currentPlayer.addAmount(-80);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 11:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"The Pit"}),
                                Translate.t("field.the_pit.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-50"}));
                        currentPlayer.addAmount(-50);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                    case 12:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Goldmine"}),
                                Translate.t("field.goldmine.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"650"}));
                        currentPlayer.addAmount(650);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}));
                        break;
                }
                GUI.setBalance(currentPlayer.getName(),currentPlayer.getAmount());
            }
            while (sum()==10);

            if (currentPlayer.getAmount() >= 3000) {
                winnerFound = true;

            }

        }
        while (!winnerFound);

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


    private void print(String msg)
    {
        GUI.showMessage(msg);
    }


    private void print(String[] messages)
    {
        this.print(String.join("\n", messages));
    }

}
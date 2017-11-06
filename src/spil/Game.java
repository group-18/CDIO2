package spil;


import desktop_resources.*;


public class Game {
    private Player[] players;
    private int playerIndex = 0;
    private DiceCup dies;


    public Game()
    {
        this.dies = new DiceCup();
    }

    public void askForPlayers(int numberOfPlayers)
    {
        this.players = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = GUI.getUserString(
                    Translate.t("writeName", new String[] {"" + (i + 1)})
            );

            this.players[i] = new Player(playerName);
        }
    }

    public void play() {
        GUI.addPlayer(players[0].getName(), players[0].getScore());
        GUI.addPlayer(players[1].getName(), players[1].getScore());
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
                this.dies.roll();
                int fieldNumber = dies.getSum();
                GUI.setCar(fieldNumber, currentPlayer.getName());
                this.print(Translate.t("turn.rollResult", new String[] {"" + dies.getSum()}));
                switch (fieldNumber) {
                    case 2:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Tower"}),
                                Translate.t("field.tower.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"+250"}));
                        currentPlayer.addScore(250);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));

                        break;
                    case 3:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Crater"}),
                                Translate.t("field.crater.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-100"}));
                        currentPlayer.addScore(-100);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 4:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Palace Gates"}),
                                Translate.t("field.palace_gates.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"100"}));
                        currentPlayer.addScore(100);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 5:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Cold Desert"}),
                                Translate.t("field.cold_desert.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-20"}));
                        currentPlayer.addScore(-20);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 6:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Walled City"}),
                                Translate.t("field.walled_city.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"180"}));
                        currentPlayer.addScore(180);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 7:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Monastery"}),
                                Translate.t("field.monastery.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"0"}));
                        currentPlayer.addScore(0);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 8:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Black Cave"}),
                                Translate.t("field.black_cave.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-70"}));
                        currentPlayer.addScore(-70);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 9:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Huts in the Mountain"}),
                                Translate.t("field.huts_in_the_mountain.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"60"}));
                        currentPlayer.addScore(60);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 10:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"The Werewall (werewolf-wall)"}),
                                Translate.t("field.the_werewall.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-80"}));
                        currentPlayer.addScore(-80);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 11:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"The Pit"}),
                                Translate.t("field.the_pit.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"-50"}));
                        currentPlayer.addScore(-50);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                    case 12:
                        this.print(new String[] {
                                Translate.t("turn.position", new String[] {"Goldmine"}),
                                Translate.t("field.goldmine.description"),
                        });
                        this.print(Translate.t("turn.score", new String[] {"650"}));
                        currentPlayer.addScore(650);
                        this.print(Translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getScore()}));
                        break;
                }
                GUI.setBalance(currentPlayer.getName(),currentPlayer.getScore());
            }
            while (dies.getSum() == 10);

            if (currentPlayer.getScore() >= 3000) {
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

            scoreboardText[i] = " - " + player.getName() + ": " + player.getScore();

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

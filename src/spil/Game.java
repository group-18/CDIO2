package spil;


import desktop_resources.*;


public class Game {
    private Player[] players;
    private int playerIndex = 0;
    private DiceCup dies;

    public Game (Player p1, Player p2){
        this.players = new Player[2];
        this.players[0]=p1;
        this.players[1]=p2;
        this.dies = new DiceCup();
    }

    public void play() {
        GUI.addPlayer(players[0].getName(), players[0].getScore());
        GUI.addPlayer(players[1].getName(), players[1].getScore());
        this.printWelcomeMessage();

        System.out.println("Spillet startes.");

        Player currentPlayer;
        boolean winnerFound = false;

        do {

            currentPlayer = getNextPlayer();

            System.out.println("Det er " + currentPlayer.getName() + "s tur. ");
            //Adds a button that executes the following do-while-statement, remove this for easy unittesting
            GUI.getUserButtonPressed("", "Kast");

            do {
                GUI.removeAllCars(currentPlayer.getName());
                this.dies.roll();
                this.print("You rolled " + dies.getSum());
                int fieldNumber = dies.getSum();
                switch (fieldNumber) {
                    case 2:
                        System.out.println("Du har landet på 'Tower'. \n" +
                                "'Tower' er kendt for dens forrygende udsigt, desværre lider de fleste af højdeskræk, når de kommer op i 500m højde. \n" +
                                "Du tænker langt, du tænker hurtigt, du sælger højdeskrækpiller og tjener derved 250.");
                        System.out.println("Udbytte: +250");
                        currentPlayer.addScore(250);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 3:
                        System.out.println("Du har landet på 'Crater'. \n" +
                                "'Crater' lugter langt ude af gamle dinosaurer, månestøv og assorteret rumskibsskrald fra den seneste Apollo-mission.\n" +
                                "Du bliver nødt til at tage en taxi væk fra attraktionen, hvilket ifølge taxiføreren maks kommer til at koste 25.");
                        System.out.println("Udbytte: -100");
                        currentPlayer.addScore(-100);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 4:
                        System.out.println("Du har landet på 'Palace gates'. \n" +
                                "Muren er stor, men dine picklocking-skills fra utallige timer i Skyrim har givet pote, og du underviser nogle skumle typer i at \n lirke døre op.");
                        System.out.println("Udbytte: +100");
                        currentPlayer.addScore(100);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 5:
                        System.out.println("Du har landet på 'Cold Desert'. \n" +
                                "Du husker tydeligt, at din mor bad dig om at tage en ekstra trøje med, og at du til dette svarede, at det da ikke bliver koldt i en ørken.\n" +
                                "For stolt til at erkende dine fejl, må du købe en ekstra varm trøje fra den nærliggende kiosk, hvor alt står på et fremmed sprog.");
                        System.out.println("Udbytte: -20");
                        currentPlayer.addScore(-20);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 6:
                        System.out.println("Du har landet på 'Walled city'. \n" +
                                "Du ankommer til 'Walled city', som egentlig før du ankom bare hed 'city'. Dine evner inden for mursten og din viden i dit tidligere \n" +
                                "ynglingsfag, sløjd, giver endelig pote, og du tjener en skilling.");
                        System.out.println("Udbytte: +180");
                        currentPlayer.addScore(180);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 7:
                        System.out.println("Du har landet på 'Monastery'. \n" +
                                "Du ankommer til 'Monastery', hvor det vrimler med alle verdens turister med hver deres bæltetaske, nyeste iPad til at tage billede \n og kæmpe solhatte." +
                                "\n Du erkender, at store mængder af mennesker ikke er dit stærkeste punkt, og tager fumlende dit rejsekatalog frem og tænker til dig selv: \n" +
                                "'Nu har jeg jo på en måde set det.");
                        System.out.println("Udbytte: 0");
                        currentPlayer.addScore(0);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 8:
                        System.out.println("Du har landet på 'Black cave' \n" +
                                "Du synes, at 'Black cave' lød spændende på TripAdvisor, nærmest adrenalinagtigt. Du bliver skuffet. 'No refunds' står der på billetten");
                        System.out.println("Udbytte: -70");
                        currentPlayer.addScore(-70);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 9:
                        System.out.println("Du har landet på 'Huts in the mountain'. \n" +
                                "Det her sted er hyggeligt, nærmest eventyrligt anlagt med udsigt over de flotte bjerge, syngende fugle og sjove, frølignende skabninger, der råber: \n" +
                                "'Mrlglglg'.");
                        System.out.println("Udbytte: +60");
                        currentPlayer.addScore(60);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 10:
                        System.out.println("Du har 'The Werewall (werewolf-wall)'. \n" +
                                "Du griner lidt over attraktionens navn, men du kan godt indse, at det er et desperat punkt på at være sjov, og derved bliver man \n" +
                                "nødt til at skrive i parantes, hvad det egentlig betyder. Du går hurtigere videre (eller: 'DuhurVidere' hahaha ... nej.");
                        System.out.println("Udbytte: -80, men en ekstra tur");
                        currentPlayer.addScore(-80);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 11:
                        System.out.println("Du har landet på 'The pit'. \n" +
                                "Du fortryder lidt, at du har brugt så lang tid på at gå ned i et hul, men du manglede en achievement.");
                        System.out.println("Udbytte: -50");
                        currentPlayer.addScore(-50);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                    case 12:
                        System.out.println("Du har landet på 'Goldmine'. \n " +
                                "## JACKPOT ## Du finder en kæmpe guldklump med værdi 650. Du når lige at råbe 'gg ez', inden du skifter tur");
                        System.out.println("Udbytte: 650");
                        currentPlayer.addScore(650);
                        System.out.println("Din pengebeholdning er nu: " + currentPlayer.getScore());
                        System.out.println("\n");
                        GUI.setCar(fieldNumber, currentPlayer.getName());
                        break;
                }
            }
            while (dies.getSum() == 10);
            GUI.setBalance(currentPlayer.getName(),currentPlayer.getScore());

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
        System.out.println("Velkommen. \n Spillet kræver to spillere, hver med en startpengebeholdning på 1000, som på skift kaster med to terninger. " +
                "Terningernes sum bestemmer placeringen på spillebrættet, der består af 11 felter (felt nr.: 2-12), hvoraf hver felt giver/trækker et bestemt på pengebeholdningen. \n " +
                "Den første spiller, er opnår en pengebeholdning på 3000 har vundet.");
    }
    private void printScoreBoard(Player winningPlayer)
    {
        this.print("");

        this.print("--- The scoreboard ---");
        for (Player player : this.players) {
            System.out.print(" - " + player.getName() + ": " + player.getScore());

            if (player == winningPlayer) {
                System.out.print(" (the winner)");
            }

            this.print("");
        }

        this.print("");
        this.print("And the winner is " + winningPlayer.getName());
    }


    private void print(String msg)
    {
        System.out.println(msg);
    }
}

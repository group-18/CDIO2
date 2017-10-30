package spil;

public class Main {

    public static void main(String[] args) {

        // Der startes med en beholdning på 1000 og sluttes med en beholdning på 3000
        int startbeholdning = 1000;
        int maksbeholdning = 3000;
        System.out.println("Start beholdningen er på: " + startbeholdning + "\n");

        // Spil med to terninger på skift og lander på et felt mellem 2-12
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();

        // Spil mellem to personer
        d1.roll();
        d2.roll();
        d3.roll();
        d4.roll();
        int sum1= d1.getFaceValue()+d2.getFaceValue();
        int sum2= d3.getFaceValue()+d4.getFaceValue();
        System.out.println("Spiller 1: Der blev slået " + d1.getFaceValue() + " og " + d2.getFaceValue());
        System.out.println("Spiller 2: Der blev slået " + d3.getFaceValue() + " og " + d4.getFaceValue());

        int nubeholdning = startbeholdning;
        int nubeholdning2 = startbeholdning;

        // Feltliste for spiller 1
        int feltslået = sum1;
        int feltværdi = 0;
        String felt;
        switch (feltslået) {
            case 1:  felt = "Kan ikke slås";
                feltværdi = 0;
                break;
            case 2:  felt = "Tower";
                feltværdi = 250;
                break;
            case 3:  felt = "Crater";
                feltværdi = -100;
                break;
            case 4:  felt = "Palace gates";
                feltværdi = 100;
                break;
            case 5:  felt = "Cold Desert";
                feltværdi = -20;
                break;
            case 6:  felt = "Walled City";
                feltværdi = 180;
                break;
            case 7:  felt = "Monastery";
                feltværdi = 0;
                break;
            case 8:  felt = "Black cave";
                feltværdi = -70;
                break;
            case 9:  felt = "Huts in the mountain";
                feltværdi = 60;
                break;
            case 10: felt = "The Werewall";
                feltværdi = -80;
                break;
            case 11: felt = "The pit";
                feltværdi = -50;
                break;
            case 12: felt = "Goldmine";
                feltværdi = 650;
                break;
            default: felt = "Prøv igen";
                feltværdi = 0;
                break;
        }

        // Feltliste for spiller 2
        int feltslået2 = sum2;
        int feltværdi2 = 0;
        String felt2;
        switch (feltslået2) {
            case 1:  felt2 = "Kan ikke slås";
                feltværdi2 = 0;
                break;
            case 2:  felt2 = "Tower";
                feltværdi2 = 250;
                break;
            case 3:  felt2 = "Crater";
                feltværdi2 = -100;
                break;
            case 4:  felt2 = "Palace gates";
                feltværdi2 = 100;
                break;
            case 5:  felt2 = "Cold Desert";
                feltværdi2 = -20;
                break;
            case 6:  felt2 = "Walled City";
                feltværdi2 = 180;
                break;
            case 7:  felt2 = "Monastery";
                feltværdi2 = 0;
                break;
            case 8:  felt2 = "Black cave";
                feltværdi2 = -70;
                break;
            case 9:  felt2 = "Huts in the mountain";
                feltværdi2 = 60;
                break;
            case 10: felt2 = "The Werewall";
                feltværdi2 = -80;
                break;
            case 11: felt2 = "The pit";
                feltværdi2 = -50;
                break;
            case 12: felt2 = "Goldmine";
                feltværdi2 = 650;
                break;
            default: felt2 = "Prøv igen";
                feltværdi2 = 0;
                break;
        }

        // Opdateret beholdning = værdien af felt + nuværende beholdning
        int nybeholdning = feltværdi + nubeholdning;
        int nybeholdning2 = feltværdi2 + nubeholdning2;

        // Tekst på aktuel felt samt opdateret beholdning
        System.out.println("\nSpiller 1 er landet på feltet '" + felt + "'\nNy beholdning:" + " " + nybeholdning);
        System.out.println("\nSpiller 2 er landet på feltet '" + felt2 + "'\nNy beholdning:" + " " + nybeholdning2);

        if (nubeholdning == maksbeholdning) {
            System.out.println("Spiller 1 har vundet");
            System.exit(0);
        }

        if (nubeholdning2 == maksbeholdning) {
            System.out.println("Spiller 2 har vundet");
            System.exit(0);
        }

        }

    }

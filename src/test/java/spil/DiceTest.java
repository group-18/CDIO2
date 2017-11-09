package spil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    //Alle test på nær getNumberOfEyes er fra vores forige rapport CDIO1. Vi har dog lavet en ny unit test på getNumberOfEyes,
    // da det var et krav at man skal nemt kunne skifte terning.
    private Dice dice;
    private Dice dice2;

    @Before
    public void setUp() throws Exception {
        this.dice = new Dice(6);
        this.dice2 = new Dice(4);
    }

    @Test
    public void roll() throws Exception {
        this.dice.roll();

        assertTrue("Dice faceValue to low", this.dice.getFaceValue() >= 1);
        assertTrue("Dice faceValue to high", this.dice.getFaceValue() <= 6);
    }

    @Test
    public void getNumberOfEyes() throws Exception {
        assertEquals(6,dice.getNumberOfEyes());
        assertEquals(6,dice2.getNumberOfEyes());
    }

    @Test
    public void rollMany() {
        int failureRate = 400;
        int numberOfRolls = 60000;

        int minFailureRate = (numberOfRolls / 6) - failureRate;
        int maxFailureRate = (numberOfRolls / 6) + failureRate;

        int[] rolls = new int[6];

        for (int i = 0; i < numberOfRolls; i++) {
            this.dice.roll();

            rolls[this.dice.getFaceValue() - 1]++;
        }

        assertTrue("Der er for få 1'er " + rolls[0], rolls[0] > minFailureRate);
        assertTrue("Der er for mange 1'er " + rolls[0], rolls[0] < maxFailureRate);

        assertTrue("Der er for få 2'er " + rolls[1], rolls[1] > minFailureRate);
        assertTrue("Der er for mange 2'er " + rolls[1], rolls[1] < maxFailureRate);

        assertTrue( "Der er for få 3'er " + rolls[2], rolls[2] > minFailureRate);
        assertTrue("Der er for mange 3'er " + rolls[2], rolls[2] < maxFailureRate);

        assertTrue("Der er for få 4'er " + rolls[3], rolls[3] > minFailureRate);
        assertTrue("Der er for mange 4'er " + rolls[3], rolls[3] < maxFailureRate);

        assertTrue("Der er for få 5'er " + rolls[4], rolls[4] > minFailureRate);
        assertTrue("Der er for mange 5'er " + rolls[4], rolls[4] < maxFailureRate);

        assertTrue("Der er for få 6'er " + rolls[5], rolls[5] > minFailureRate);
        assertTrue("Der er for mange 6'er " + rolls[5], rolls[5] < maxFailureRate);
    }

    @Test
    public void rollCountMultiple() {
        int numberOfDies = 2;
        int numberOfRolls = 60000;

        Dice d1 = new Dice();
        Dice d2 = new Dice();

        int[] rolls = new int[numberOfDies * 6 + 1];

        for (int i = 0; i < numberOfRolls; i++) {
            d1.roll();
            d2.roll();

            int sum = d1.getFaceValue() + d2.getFaceValue();

            rolls[sum]++;
        }

        double oneRollPercent = (double) 100 / numberOfRolls;

        double totalPercentage = 0;
        double failureRate = 0.75;
        for (int i = numberOfDies; i < rolls.length; i++) {
            double percentage = (double) rolls[i] * oneRollPercent;
            double expectedPercentage = this.numPossibilities(numberOfDies, i) * (100.0 / 36.0);

            assertTrue("Sum " + i + " med sandsynlighed " + percentage + "% er for lav, min. " + (expectedPercentage - failureRate) + "%", percentage >= expectedPercentage - failureRate);
            assertTrue("Sum " + i + " med sandsynlighed " + percentage + "% er for høj, max. " + (expectedPercentage + failureRate) + "%", percentage <= expectedPercentage + failureRate);

            totalPercentage += percentage;
        }

        assertTrue("Summen giver ikke 100% +- 1% : " + totalPercentage, totalPercentage >= 99 && totalPercentage <= 101);
    }

    private int numPossibilities(int numDice, int sum) {
        if (numDice == sum) {
            return 1;
        } else if (numDice == 0 || sum < numDice) {
            return 0;
        } else {
            return this.numPossibilities(numDice, sum - 1) +
                    this.numPossibilities(numDice - 1, sum - 1) -
                    this.numPossibilities(numDice - 1, sum - 7);
        }
    }

    @After
    public void tearDown() throws Exception {
    }


}
package spil;


public class Dice {
    private int faceValue;
    private int numberOfEyes;

    public Dice()
    {
        this.numberOfEyes = 6;
    }

    //This constructor makes it able to change the number of eyes on the die.
    public Dice(int numberOfEyes)
    {
        this.numberOfEyes = numberOfEyes;
    }

    public int getNumberOfEyes()
    {
        return this.numberOfEyes;
    }

    public int getFaceValue()
    {
        return this.faceValue;
    }

    //Rolls the die, using the numberOfEyes as factor, so that it will work for different dies.
    public void roll()
    {
        this.faceValue = (int) (Math.random() * this.numberOfEyes) + 1;
    }
}
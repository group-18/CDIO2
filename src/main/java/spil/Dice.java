package spil;


public class Dice {
    private int faceValue;
    private int numberOfEyes;

    public Dice()
    {
        this.numberOfEyes = 6;
    }

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

    public void roll()
    {
        this.faceValue = (int) (Math.random() * this.numberOfEyes) + 1;
    }
}
package spil;

public class Dice {
    private int faceValue;
    private int numberOfEyes;

    public Dice(int numberOfEyes){this.numberOfEyes = numberOfEyes;}

    public void roll()
    {
        this.faceValue = (int) (Math.random() * numberOfEyes) + 1;
    }

    public int getNumberOfEyes(){return this.numberOfEyes;}

    public int getFaceValue()
    {
        return this.faceValue;
    }

}

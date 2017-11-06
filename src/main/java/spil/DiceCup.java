package spil;


public class DiceCup {
    private Dice d1;
    private Dice d2;


    public DiceCup()
    {
        this.d1 = new Dice();
        this.d2 = new Dice();
    }


    public void roll()
    {
        this.d1.roll();
        this.d2.roll();
    }


    public int getSum()
    {
        return this.d1.getFaceValue() + this.d2.getFaceValue();
    }
}

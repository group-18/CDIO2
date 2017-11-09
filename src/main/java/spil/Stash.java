package spil;


public class Stash {
    private int amount;

    public Stash()
    {
    }

    public Stash(int startAmount)
    {
        this.amount = startAmount;
    }

    public int getAmount()
    {
        return this.amount;
    }

    public void addAmount(int numberToAdd)
    {
        this.amount += numberToAdd;

        if (this.amount < 0) {
            this.amount = 0;
        }
    }
}
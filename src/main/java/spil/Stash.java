package spil;

public class Stash {
    private int amount=1000;

    public int getAmount(){
        return this.amount;
    }

    public void addAmount(int numberToAdd){
        if ((this.amount + numberToAdd)<  0){
            this.amount = 0;
        }
        else {
            this.amount += numberToAdd;
        }

    }


}
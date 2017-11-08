package spil;


public class Player {
    private String name;
    private Stash stash;

    public Player(String name)
    {
        this.name = name;
        this.stash = new Stash();
    }

    public String getName()
    {
        return this.name;
    }

    public int getAmount(){
        return this.stash.getAmount();
    }

    public void addAmount(int numberToAdd)
    {
        this.stash.addAmount(numberToAdd);
    }
}
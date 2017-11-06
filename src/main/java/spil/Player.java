package spil;


public class Player {
    private String name;
    private int score=1000;

    public Player(String name)
    {
        this.name = name;
    }


    public String getName()
    {
        return this.name;
    }


    public int getScore()
    {
        return score;
    }


    public void addScore(int numberToAdd)
    {
        this.score += numberToAdd;
    }
}

package club.quan9.luck_counter.SomePrivateClasses;

/**
 * Created by wily on 2018/3/20.
 */

public class Rarity
{
    String RarityName;
    double Probability;

    public Rarity(String RarityName,double Probability)
    {
        this.RarityName=RarityName;
        this.Probability=Probability;
    }

    public double getProbability()
    {
        return Probability;
    }

    public String getRarityName()
    {
        return RarityName;
    }
}

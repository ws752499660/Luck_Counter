package club.quan9.luck_counter.SomePrivateClasses;

import java.lang.Math;

/**
 * Created by wily on 2018/3/21.
 */

public class Calculation
{
    double rarities[];
    double RP;
    double nextRarity;
    final double RP_To_nextRaity_Coefficient=2.1;

    public Calculation(double rarities[],double RP)
    {
        this.rarities=rarities;
        this.RP=RP;
        this.nextRarity=0;
    }

    public Calculation(double rarites[])
    {
        this.rarities=rarites;
        this.RP=0;
        this.nextRarity=0;
    }

    public Calculation()
    {}

    public double AlterRP(double rarity)
    {
        double fix=0;
        if(rarity>=0.5)     //可认为这样的事件是可以增加人品的
        {
            fix = (Math.log10(rarity) - Math.log10(0.5)) * rarity;
        }
        if(rarity<0.5)      //可以认为这样的事件是减少人品的
        {
            fix=(Math.log10(rarity)-Math.log10(0.5)) *(1-rarity);
        }
        return fix;
    }

    public double Calculate_nextRarity(Rarity OriginRarity)
    {
        nextRarity=Math.pow(RP_To_nextRaity_Coefficient,RP)*OriginRarity.Probability;
        return nextRarity;
    }
}

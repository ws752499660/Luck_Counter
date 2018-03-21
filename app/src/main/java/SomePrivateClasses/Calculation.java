package SomePrivateClasses;

import java.lang.Math;

/**
 * Created by wily on 2018/3/21.
 */

public class Calculation
{
    double rarity;
    double RP;
    double nextRarity;
    final double RP_To_nextRaity_Coefficient=2.1;

    public Calculation(double rarity,double RP)
    {
        this.rarity=rarity;
        this.RP=RP;
        this.rarity=0;
    }

    public Calculation()
    {
        this.rarity=0;
        this.RP=0;
        this.nextRarity=0;
    }

    public double AlterRP(double rarity,double RPold)
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
        RP=RP+fix;
        return fix;
    }

    public double Calculate_nextRarity(Rarity OriginRarity)
    {
        nextRarity=Math.pow(RP_To_nextRaity_Coefficient,RP)*OriginRarity.Probability;
        return nextRarity;
    }
}

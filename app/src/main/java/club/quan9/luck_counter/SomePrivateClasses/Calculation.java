package club.quan9.luck_counter.SomePrivateClasses;

import android.content.SharedPreferences;

import java.lang.Math;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by wily on 2018/3/21.
 */

public class Calculation
{
    double rarities[];
    double RP;
    double nextRarity[];
    final double RP_To_nextRaity_Coefficient=2.1;

    public Calculation(double rarities[],double RP)
    {
        this.rarities=rarities;
        this.RP=RP;
    }

    public Calculation(double rarites[])
    {
        this.rarities=rarites;
        this.RP=0;
    }

    public Calculation()
    {}

    public void CalculateFix(int[] num)
    {
        double fix=0;
        for(int i=0;i<rarities.length;i++)
            fix=AlterRP(rarities[i])*num[i]+fix;
        RP=RP+fix;
    }

    private double AlterRP(double rarity)
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

    public void Calculate_nextRarity(double[] OriginRarity)
    {
        nextRarity=new double[OriginRarity.length];
        for(int i=0;i<OriginRarity.length;i++)
            nextRarity[i]=Math.pow(RP_To_nextRaity_Coefficient,RP)*OriginRarity[i];
    }

    public void ApplyForPref(SharedPreferences.Editor editor)
    {
        editor.putFloat("RP",(float) RP);
        editor.apply();
    }

    public double[] getNextRarity()
    {
        return nextRarity;
    }
}

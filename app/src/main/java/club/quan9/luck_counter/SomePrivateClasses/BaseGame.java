package club.quan9.luck_counter.SomePrivateClasses;

/**
 * Created by wily on 2018/3/20.
 */

public class BaseGame
{
    String GameName;
    double[] rarity;

    public BaseGame(String GameName)
    {
        switch (GameName)
        {
            case "炉石传说":
                this.GameName=GameName;
                rarity=new double[8];
                rarity[0]=1.1;     //白
                rarity[1]=0.25;      //蓝
                rarity[2]=0.04;    //紫
                rarity[3]=0.01;      //橙
                rarity[4]=0.75*0.0588;     //金白
                rarity[5]=0.25*0.0588;      //金蓝
                rarity[6]=0.04*0.0588;    //金紫
                rarity[7]=0.01*0.0588;       //金橙
                break;
            case "FGO":
                this.GameName=GameName;

        }
    }

    public double[] getRarity()
    {
        return rarity;
    }
}

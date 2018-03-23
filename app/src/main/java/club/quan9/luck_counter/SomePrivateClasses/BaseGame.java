package club.quan9.luck_counter.SomePrivateClasses;

/**
 * Created by wily on 2018/3/20.
 */

public class BaseGame
{
    String GameName;
    Rarity[] rarity;

    public BaseGame(String GameName)
    {
        switch (GameName)
        {
            case "炉石传说":
                this.GameName=GameName;
                rarity=new Rarity[8];
                rarity[0]=new Rarity("white",0.75);
                rarity[1]=new Rarity("blue",0.25);
                rarity[2]=new Rarity("purple",0.04);
                rarity[3]=new Rarity("gold",0.01);
                rarity[4]=new Rarity("whiteG",0.75*0.0588);
                rarity[5]=new Rarity("blueG",0.25*0.0588);
                rarity[6]=new Rarity("purpleG",0.04*0.0588);
                rarity[7]=new Rarity("goldG",0.01*0.588);
                break;
            case "FGO":
                this.GameName=GameName;

        }
    }

    public Rarity[] getRarity()
    {
        return rarity;
    }
}

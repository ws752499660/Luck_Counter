package SomePrivateClasses;

/**
 * Created by wily on 2018/3/20.
 */

public class BaseGame
{
    String GameName;
    Rarity[] rarity;

    public BaseGame(String GameName,int position)
    {
        switch (GameName)
        {
            case "炉石传说":
                this.GameName=GameName;
                rarity=new Rarity[8];
                rarity[0]=new Rarity("white",)
        }
    }
}

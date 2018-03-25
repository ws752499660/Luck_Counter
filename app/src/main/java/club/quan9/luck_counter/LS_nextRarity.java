package club.quan9.luck_counter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import club.quan9.luck_counter.SomePrivateClasses.ArrayAndString;
import club.quan9.luck_counter.SomePrivateClasses.ArrayToPref;
import club.quan9.luck_counter.SomePrivateClasses.BaseGame;

public class LS_nextRarity extends AppCompatActivity
{
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;
    private BaseGame LS=new BaseGame("炉石传说");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ls_next_rarity);
        editor=getSharedPreferences("savePlace",MODE_PRIVATE).edit();
        pref=getSharedPreferences("savePlace",MODE_PRIVATE);
        setText();
    }

    private void setText()
    {
        double nextRarity[];
        nextRarity= ArrayAndString.StringToDouble(ArrayToPref.getArrary("LS_nextRarity",pref));
        TextView[] t=new TextView[8];
        t[0]=(TextView) findViewById(R.id.nextWhite);
        t[1]=(TextView) findViewById(R.id.nextBlue);
        t[2]=(TextView) findViewById(R.id.nextPurple);
        t[3]=(TextView) findViewById(R.id.nextGold);
        t[4]=(TextView) findViewById(R.id.nextWhiteG);
        t[5]=(TextView) findViewById(R.id.nextBlueG);
        t[6]=(TextView) findViewById(R.id.nextPurpleG);
        t[7]=(TextView) findViewById(R.id.nextGoldG);
        for(int i=0;i<8;i++)
        {
            double fix=nextRarity[i] - LS.getRarity()[i];
            if (fix > 0)
                t[i].setText("概率  +"+fix*100+"%");
            else
                t[i].setText("概率  "+fix*100+"%");
        }
    }
}

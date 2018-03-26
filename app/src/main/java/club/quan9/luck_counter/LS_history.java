package club.quan9.luck_counter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import club.quan9.luck_counter.SomePrivateClasses.ArrayAndString;
import club.quan9.luck_counter.SomePrivateClasses.ArrayToPref;

public class LS_history extends AppCompatActivity
{
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ls_history);
        pref=getSharedPreferences("savePlace",MODE_PRIVATE);
        settext();
    }

    private void settext()
    {
        int[] cardsnum= ArrayAndString.StringToInt(ArrayToPref.getArrary("LS_cardsnum_sum",pref));
        TextView[] text=new TextView[8];
        text[0]=(TextView) findViewById(R.id.ls_white_Hnum);
        text[1]=(TextView) findViewById(R.id.ls_blue_Hnum);
        text[2]=(TextView) findViewById(R.id.ls_purple_Hnum);
        text[3]=(TextView) findViewById(R.id.ls_gold_Hnum);
        text[4]=(TextView) findViewById(R.id.ls_whiteG_Hnum);
        text[5]=(TextView) findViewById(R.id.ls_blueG_Hnum);
        text[6]=(TextView) findViewById(R.id.ls_purpleG_Hnum);
        text[7]=(TextView) findViewById(R.id.ls_goldG_Hnum);
        for(int i=0;i<8;i++)
            text[i].setText(((Integer) cardsnum[i]).toString());
    }
}

package club.quan9.luck_counter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import club.quan9.luck_counter.SomePrivateClasses.ArrayToPref;
import club.quan9.luck_counter.SomePrivateClasses.ArrayAndString;
import club.quan9.luck_counter.SomePrivateClasses.BaseGame;
import club.quan9.luck_counter.SomePrivateClasses.Calculation;

public class input_lushi extends AppCompatActivity
{
    //0-白，1-蓝，2-紫，3-橙，4-金白，5-金蓝，6-金紫，7-金橙
    public int[] cardsNum=new int[8];
    private Calculation calculation;
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_lushi);
        pref=getSharedPreferences("savePlace",MODE_PRIVATE);
        Button button=(Button) findViewById(R.id.ls_finish_input_button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getnums();
                BaseGame LS=new BaseGame("炉石传说");
                calculate(LS);
                saveNextRarity(calculation.getNextRarity());
                saveCardsNum();
            }
        });
    }

    private void getnums()
    {
        cardsNum[0]=Integer.valueOf(((EditText) findViewById(R.id.ls_white_num)).getText().toString());
        cardsNum[1]=Integer.valueOf(((EditText) findViewById(R.id.ls_blue_num)).getText().toString());
        cardsNum[2]=Integer.valueOf(((EditText) findViewById(R.id.ls_purple_num)).getText().toString());
        cardsNum[3]=Integer.valueOf(((EditText) findViewById(R.id.ls_gold_num)).getText().toString());
        cardsNum[4]=Integer.valueOf(((EditText) findViewById(R.id.ls_whiteG_num)).getText().toString());
        cardsNum[5]=Integer.valueOf(((EditText) findViewById(R.id.ls_blueG_num)).getText().toString());
        cardsNum[6]=Integer.valueOf(((EditText) findViewById(R.id.ls_purpleG_num)).getText().toString());
        cardsNum[7]=Integer.valueOf(((EditText) findViewById(R.id.ls_goldG_num)).getText().toString());
    }

    /*private double calculateFix(BaseGame LS)
    {
        Calculation calculation=new Calculation();
        double AlterRP=0;
        int i=0;
        for(int num:cardsNum)
        {
            for(int j=0;j<num;j++)
                AlterRP=AlterRP+calculation.AlterRP(LS.getRarity()[i]);
            i++;
        }
        return AlterRP;
    }*/

    private void calculate(BaseGame LS)     //计算RP修正值，并根据RP修正值修正RP，根据新RP求下一抽概率
    {
        calculation=new Calculation(LS.getRarity(),pref.getFloat("RP",0));
        calculation.CalculateFix(cardsNum);
        calculation.Calculate_nextRarity(LS.getRarity());
        editor=getSharedPreferences("savePlace",MODE_PRIVATE).edit();
        calculation.ApplyForPref(editor);
    }

    private void saveNextRarity(double[] nextRarity)       //存储下一抽的概率
    {
        ArrayToPref.putArrary("LS_nextRarity",ArrayAndString.doubleToString(nextRarity),pref,editor);
    }

    private void saveCardsNum()     //存储本次抽卡的情况
    {
        int[] cardsNumSum=new int[8];
        int[] cardsNumOld=ArrayAndString.StringToInt((ArrayToPref.getArrary("LS_cardsnum_sum",pref)));
        for(int i=0;i<8;i++)
            cardsNumSum[i]=cardsNum[i]+cardsNumOld[i];
        ArrayToPref.putArrary("LS_cardsnum_sum", ArrayAndString.intToString(cardsNumSum),pref,editor);
    }
}

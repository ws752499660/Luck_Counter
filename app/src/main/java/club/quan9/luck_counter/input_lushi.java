package club.quan9.luck_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class input_lushi extends AppCompatActivity
{
    //0-白，1-蓝，2-紫，3-橙，4-金白，5-金蓝，6-金紫，7-金橙
    public int[] cardsNum=new int[8];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_lushi);
        Button button=(Button) findViewById(R.id.ls_finish_input_button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getnums();
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
}
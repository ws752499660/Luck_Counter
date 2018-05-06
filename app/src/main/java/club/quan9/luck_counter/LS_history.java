package club.quan9.luck_counter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import club.quan9.luck_counter.SomePrivateClasses.ArrayAndString;
import club.quan9.luck_counter.SomePrivateClasses.ArrayToPref;

public class LS_history extends AppCompatActivity
{
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ls_history);
        Button clear=(Button) findViewById(R.id.ls_clear_input_button);
        pref=getSharedPreferences("savePlace",MODE_PRIVATE);
        editor=getSharedPreferences("savePlace",MODE_PRIVATE).edit();
        settext();
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog(v);
                settext();
                refresh();
            }
        });
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
        TextView RP=(TextView) findViewById(R.id.RP);
        float rp=pref.getFloat("RP",0);
        RP.setText(String.format("%.4f",rp));
    }

    //**警示对话框**//
    private void AlertDialog(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(LS_history.this);
        builder.setTitle("警告");
        builder.setMessage("你的确是要清空之前的数据吗？");
        builder.setCancelable(true);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                int[] initlizing=new int[8];
                ArrayToPref.putArrary("LS_cardsnum_sum",ArrayAndString.intToString(initlizing),pref,editor);
                ArrayToPref.putArrary("LS_nextRarity",ArrayAndString.intToString(initlizing),pref,editor);
                editor.putFloat("RP",0);
                editor.apply();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void refresh()
    {
        finish();
        onCreate(null);
    }
}

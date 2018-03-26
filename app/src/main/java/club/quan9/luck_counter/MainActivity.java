package club.quan9.luck_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        final String[] games={"炉石传说","命运：冠位指定（FGO）"};
        spinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,games));
        final Object[] objs=new Object[1];
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String gamename=games[position];
                objs[0]=gamename;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });

        Button button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch ((String)objs[0])
                {
                    case "炉石传说":
                        Intent intent = new Intent(MainActivity.this, input_lushi.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}

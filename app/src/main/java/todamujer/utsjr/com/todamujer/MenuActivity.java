package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MenuActivity extends ActionBarActivity {

    ImageButton btnEmbarazo, btnSintomas, btnCalendario, btnHumor, btnCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnEmbarazo=(ImageButton)findViewById(R.id.BtnEmbarazo);
        btnSintomas=(ImageButton)findViewById(R.id.BtnSintomas);
        btnCalendario=(ImageButton)findViewById(R.id.BtnCalendario);
        btnHumor=(ImageButton)findViewById(R.id.BtnHumor);
        btnCitas=(ImageButton)findViewById(R.id.BtnCitas);

        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,CitasActivity.class);
                startActivity(intent);
            }
        });
        btnEmbarazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,EmbarazoActivity.class);
                startActivity(intent);
            }
        });
        btnSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,SintomasActivity.class);
                startActivity(intent);
            }
        });
        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,CalendarioActivity.class);
                startActivity(intent);
            }
        });
        btnHumor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,HumorActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

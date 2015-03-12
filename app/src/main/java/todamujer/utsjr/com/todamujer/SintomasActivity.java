package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SintomasActivity extends ActionBarActivity {

    private ListView lstSintomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        lstSintomas = (ListView) findViewById(R.id.LstSintomas);

        List<Item> items=new ArrayList<Item>();

        items.add(new Item(R.drawable.sintomas_mareos,"Mareo"));
        items.add(new Item(R.drawable.sintomas_escalofrio,"Escalofrio"));
        items.add(new Item(R.drawable.sintomas_gripa,"Gripa"));
        items.add(new Item(R.drawable.sintomas_resfriado,"Resfriado"));
        items.add(new Item(R.drawable.sintomas_salpullidos,"Salpullido"));
        items.add(new Item(R.drawable.sintomas_temperatura,"Temperatura"));

        this.lstSintomas.setAdapter(new ItemAdapter(this,items));

        lstSintomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item=(Item)lstSintomas.getAdapter().getItem(position);
                Intent intent=new Intent(SintomasActivity.this,DetalleSintomaActivity.class);
                Bundle b=new Bundle();

                b.putString("sintoma",item.getSintoma());
                intent.putExtras(b);
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sintomas, menu);
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

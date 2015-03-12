package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class EmbarazoActivity extends ActionBarActivity {
    private ListView lstEmba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embarazo);

        lstEmba=(ListView)findViewById(R.id.LstEmba);


        List<ItemEmbarazo> items=new ArrayList<ItemEmbarazo>();

        items.add(new ItemEmbarazo(R.drawable.mes1,"Mes 1"));
        items.add(new ItemEmbarazo(R.drawable.mes2,"Mes 2"));
        items.add(new ItemEmbarazo(R.drawable.mes3,"Mes 3"));
        items.add(new ItemEmbarazo(R.drawable.mes4,"Mes 4"));
        items.add(new ItemEmbarazo(R.drawable.mes5,"Mes 5"));
        items.add(new ItemEmbarazo(R.drawable.mes6,"Mes 6"));
        items.add(new ItemEmbarazo(R.drawable.mes7,"Mes 7"));
        items.add(new ItemEmbarazo(R.drawable.mes8,"Mes 8"));
        items.add(new ItemEmbarazo(R.drawable.mes9,"Mes 9"));

        this.lstEmba.setAdapter(new ItemAdapterEmbarazo(this,items));

        lstEmba.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemEmbarazo itemEmbarazo=(ItemEmbarazo)lstEmba.getAdapter().getItem(position);
                Intent intent=new Intent(EmbarazoActivity.this,DetalleEmbarazoActivity.class);
                Bundle b=new Bundle();
                b.putString("emba",itemEmbarazo.getEmba());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_embarazo, menu);
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

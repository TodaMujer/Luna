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


public class HumorActivity extends ActionBarActivity {
    private ListView lstHumor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humor);

        lstHumor=(ListView)findViewById(R.id.LstHumor);


        List<ItemHumor> items=new ArrayList<ItemHumor>();

        items.add(new ItemHumor(R.drawable.humor_feliz1,"Feliz"));
        items.add(new ItemHumor(R.drawable.humor_estudiosa1,"Inspirada"));
        items.add(new ItemHumor(R.drawable.humor_molesta1,"Molesta"));
        items.add(new ItemHumor(R.drawable.humor_furiosa1,"Furiosa"));
        items.add(new ItemHumor(R.drawable.humor_triste1,"Triste"));
        items.add(new ItemHumor(R.drawable.humor_muy_triste1,"Muy triste"));
        items.add(new ItemHumor(R.drawable.humor_sorprendida1,"Sorprendida"));

        this.lstHumor.setAdapter(new ItemAdapterHumor(this,items));

        lstHumor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemHumor itemHumor=(ItemHumor)lstHumor.getAdapter().getItem(position);
                Intent intent=new Intent(HumorActivity.this,DetalleHumorActivity.class);
                Bundle b=new Bundle();
                b.putString("humor", itemHumor.getHumor());
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_humor, menu);
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

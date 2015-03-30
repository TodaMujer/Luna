package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;


public class CitasActivity extends ActionBarActivity {
    private ListView lstCitas;
    private Button btnAgregarCitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        lstCitas=(ListView)findViewById(R.id.LstCitas);
        btnAgregarCitas=(Button)findViewById(R.id.BtnAgregarCita);


         CitasDAO mdao=new CitasDAO(this);
        try{
            mdao.open();
            ArrayList<Citas> searchResult=(ArrayList<Citas>)mdao.getCitas();
            lstCitas.setAdapter(new AdaptadorCitas(this, searchResult));
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            mdao.close();
        }

        //agregamos un Listener al ListView
        lstCitas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Citas m=(Citas)lstCitas.getItemAtPosition(position);

                Intent datosUsuario=new Intent(CitasActivity.this,DetallesCita.class);

                Bundle b=new Bundle();
                b.putInt("id", m.getId());
                b.putString("fecha", m.getFecha());
                b.putString("hora", m.getHora());
                b.putString("nombre", m.getNombre());
                b.putString("tipo", m.getTipo());
                b.putString("numero",m.getNumero());
                b.putString("ubicacion",m.getUbicacion());

                datosUsuario.putExtras(b);
                startActivity(datosUsuario);
            }
        });


        btnAgregarCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registoCitas = new Intent(CitasActivity.this, AgregaCita.class);
                startActivity(registoCitas);

            }
        });

    }


    @Override
    protected void onResume(){
        super.onResume();
        lstCitas=(ListView)findViewById(R.id.LstCitas);

        CitasDAO cdao=new CitasDAO(this);
        try{
            cdao.open();
            ArrayList<Citas> searchResult=(ArrayList<Citas>)cdao.getCitas();
            lstCitas.setAdapter(new AdaptadorCitas(this, searchResult));
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            cdao.close();
        }

    }

    @Override
    public void onBackPressed(){
        finish();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_citas, menu);
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

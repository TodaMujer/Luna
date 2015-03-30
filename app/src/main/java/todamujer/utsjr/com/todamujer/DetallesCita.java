package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Date;


public class DetallesCita extends ActionBarActivity {

    private TextView detallesLblFecha, detallesLblHora, detallesLblNombre, detallesLblTipo, detallesLblNumero, detallesLblUbicacion;
    private ImageButton  detallesBtnEliminar, detallesBtnModificar;


    private int id;
    private String fecha, hora, nombre, tipo, numero, ubicacion;

    private CitasDAO mdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_cita);

        detallesLblFecha=(TextView)findViewById(R.id.DetallesLblFecha);
        detallesLblHora=(TextView)findViewById(R.id.DetallesLblHora);
        detallesLblNombre=(TextView)findViewById(R.id.DetallesLblNombre);
        detallesLblTipo=(TextView)findViewById(R.id.DetallesLblTipo);
        detallesLblNumero=(TextView)findViewById(R.id.DetallesLblNumero);
        detallesLblUbicacion=(TextView)findViewById(R.id.DetallesLblUbicacion);


        detallesBtnEliminar=(ImageButton)findViewById(R.id.DetallesBtnEliminar);
        detallesBtnModificar=(ImageButton)findViewById(R.id.DetallesBtnModificar);

        //obtenemos los valores que viene en el Intent
        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        fecha=b.getString("fecha");
        hora=b.getString("hora");
        nombre=b.getString("nombre");
        tipo=b.getString("tipo");
        numero=b.getString("numero");
        ubicacion=b.getString("ubicacion");

        //mostramos los valoes en los TextView correspondientes
        detallesLblFecha.setText("FECHA: "+fecha);
        detallesLblHora.setText("HORA: "+hora);
        detallesLblNombre.setText("NOMBRE: "+nombre);
        detallesLblTipo.setText("TIPO: "+tipo);
        detallesLblNumero.setText("NUMERO: "+numero);
        detallesLblUbicacion.setText("UBICACION: "+ubicacion);



        //accion boton modificar
        detallesBtnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ModificarCitas=new Intent(DetallesCita.this,ModificarCitas.class);
                ModificarCitas.putExtra("id",id);
                startActivity(ModificarCitas);
                DetallesCita.this.finish();
            }
        });

        //accion boton eliminar
        detallesBtnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdao=new CitasDAO(DetallesCita.this);
                try{
                    mdao.open();
                    if(mdao.eliminarCitas(id)){
                        Toast.makeText(DetallesCita.this,"Cita Eliminada", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(DetallesCita.this,"Cita No eliminada", Toast.LENGTH_LONG).show();
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
                mdao.close();
                DetallesCita.this.finish();
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalles_cita, menu);
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

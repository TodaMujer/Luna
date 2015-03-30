package todamujer.utsjr.com.todamujer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class ModificarCitas extends ActionBarActivity {


    private EditText modificarTxtFecha, modificarTxtHora, modificarTxtNombre, modificarTxtTipo, modificarTxtNumero, modificarTxtUbicacion;
    private Button modificarBtnRegistrar,modificarBtnRegresar;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_citas);

        modificarTxtFecha=(EditText)findViewById(R.id.ModificarTxtFecha);
        modificarTxtHora=(EditText)findViewById(R.id.ModificarTxtHora);
        modificarTxtNombre=(EditText)findViewById(R.id.ModificarTxtNombre);
        modificarTxtTipo=(EditText)findViewById(R.id.ModificarTxtTipo);
        modificarTxtNumero=(EditText)findViewById(R.id.ModificarTxtNumero);
        modificarTxtUbicacion=(EditText)findViewById(R.id.ModificarTxtUbicacion);
        modificarBtnRegistrar=(Button)findViewById(R.id.ModificarBtnRegistrar);
        modificarBtnRegresar=(Button)findViewById(R.id.ModificarBtnRegresar);

        CitasDAO mdao=new CitasDAO(this);

        //obtenemos los datos del intent
        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        Citas m=new Citas();

        //abimos la conexion y buacamos al contacto quee yenga ese ID y asi lo asignamos a un objeto
        try{
            mdao.open();
            m=mdao.buscarCitas(id);

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            mdao.close();
        }

        //mostramos los datos en los cuador de txto para que el usuario los modifique

        modificarTxtFecha.setText(m.getFecha());
        modificarTxtHora.setText(m.getHora());
        modificarTxtNombre.setText(m.getNombre());
        modificarTxtTipo.setText(m.getTipo());
        modificarTxtNumero.setText(m.getNumero());
        modificarTxtUbicacion.setText(m.getUbicacion());

        modificarBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Citas m=new Citas();
                m.setId(ModificarCitas.this.id);
                m.setFecha(modificarTxtFecha.getText().toString());
                m.setHora(modificarTxtHora.getText().toString());
                m.setNombre(modificarTxtNombre.getText().toString());
                m.setTipo(modificarTxtTipo.getText().toString());
                m.setNumero(modificarTxtNumero.getText().toString());
                m.setUbicacion(modificarTxtUbicacion.getText().toString());


                CitasDAO cdao=new CitasDAO(ModificarCitas.this);
                try{
                    cdao.open();
                    if(cdao.modificarCitas(m)){
                        Toast.makeText(ModificarCitas.this, "Cita Modificada", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ModificarCitas.this, "Cita NO Modificada", Toast.LENGTH_LONG).show();
                    }
                }
                catch (SQLException aqle){

                }
                finally {
                    cdao.close();

                }
                ModificarCitas.this.finish();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_citas, menu);
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

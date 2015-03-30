package todamujer.utsjr.com.todamujer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;


public class AgregaCita extends ActionBarActivity {
    private EditText txtfecha, txthora, txtnombre, txtmotivo, txtnumero, txtubicacion;
    private Button btnAceptar, btnRegresar;
    private CitasDAO mdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrega_cita);


        txtfecha = (EditText) findViewById(R.id.TxtFecha);
        txthora = (EditText) findViewById(R.id.TxtHora);
        txtnombre = (EditText) findViewById(R.id.TxtNombre);
        txtmotivo = (EditText) findViewById(R.id.TxtMotivo);
        txtnumero = (EditText) findViewById(R.id.TxtNumero);
        txtubicacion = (EditText) findViewById(R.id.TxtUbicacion);
        btnAceptar = (Button) findViewById(R.id.BtnAgregarCita);
        btnRegresar = (Button) findViewById(R.id.BtnRegresar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //declaramos un objeto de tipo contacto
                Citas m = new Citas();

                //asignamos los valosres de los cuadrso de texto a los atributos del objeto
                m.setFecha(txtfecha.getText().toString());
                m.setHora(txthora.getText().toString());
                m.setNombre(txtnombre.getText().toString());
                m.setTipo(txtmotivo.getText().toString());
                m.setNumero(txtnumero.getText().toString());
                m.setUbicacion(txtubicacion.getText().toString());


                //inicializamos el dao y abrimos la conexion

                mdao = new CitasDAO(AgregaCita.this);
                try {
                    mdao.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //llamamos al metodo agregar contacto del DAO y generamos mensaje en consecuencia
                if (mdao.agregarCitas(m)) {
                    mostarMensaje("NUEVA CITA", "Aceptar");
                } else {
                    mostarMensaje("NUEVA CITA", "No se pudo guardar");
                }


            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregaCita.this.finish();
            }
        });

    }


    //metodo para generar el cuadro de dialogo con el mensaje
    private void mostarMensaje(String titulo, String mensaje) {
        //declaramos e instanciamos el objeto AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        TextView lblMensaje = new TextView(this);
        builder.setTitle(titulo);
        lblMensaje.setText(mensaje);
        lblMensaje.setTextSize(20);
        lblMensaje.setGravity(Gravity.CENTER_HORIZONTAL);

        builder.setView(lblMensaje);

        builder.setCancelable(false);


        //agregamos boton al dialogo

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                //bprramos contenido de los cuadros
                ((EditText) (findViewById(R.id.TxtFecha))).setText("");
                ((EditText) (findViewById(R.id.TxtHora))).setText("");
                ((EditText) (findViewById(R.id.TxtNombre))).setText("");
                ((EditText) (findViewById(R.id.TxtMotivo))).setText("");
                ((EditText) (findViewById(R.id.TxtNumero))).setText("");
                ((EditText) (findViewById(R.id.TxtUbicacion))).setText("");

                //enviamos el cursor al primer cuadro
                ((EditText) (findViewById(R.id.TxtNombre))).requestFocus();
            }
        });

        builder.show();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agrega_cita, menu);
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

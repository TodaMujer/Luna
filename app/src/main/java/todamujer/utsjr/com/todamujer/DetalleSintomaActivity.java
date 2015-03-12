package todamujer.utsjr.com.todamujer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetalleSintomaActivity extends ActionBarActivity {
    TextView lblSintoma, lblDetallesSintoma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sintoma);

        lblSintoma=(TextView)findViewById(R.id.LblSintoma);
        lblDetallesSintoma=(TextView)findViewById(R.id.LblDetallesSintoma);


        Bundle b=this.getIntent().getExtras();

        lblSintoma.setText(b.getString("sintoma"));

        if(b.getString("sintoma").equals("Mareo")){
            lblDetallesSintoma.setText("•\tEvitando los movimientos o cambios de posición repentinos.\n" +
                    "•\tPermaneciendo quieto y descansando cuando tenga síntomas.\n" +
                    "•\tEvitando las luces brillantes, la TV y la lectura cuando tenga síntomas.\n");
        }
        else if(b.getString("sintoma").equals("Escalofrio")){
            lblDetallesSintoma.setText("Los medicamentos como el paracetamol son efectivos para combatir la fiebre y los escalofríos.\n" +
                    "No se envuelva en mantas si tiene temperatura alta. Tampoco use ventiladores ni aire acondicionado. Estas medidas sólo provocarán que sus escalofríos empeoren e incluso harán que la fiebre aumente. Los medicamentos como el paracetamol son efectivos para combatir la fiebre y los escalofríos.\n" +
                    "No se envuelva en mantas si tiene temperatura alta. Tampoco use ventiladores ni aire acondicionado. Estas medidas sólo provocarán que sus escalofríos empeoren e incluso harán que la fiebre aumente.\n");
        }
        else if(b.getString("sintoma").equals("Gripa")){
            lblDetallesSintoma.setText("En la actualidad, son dos las familias de fármacos comercializados para el tratamiento de la gripe:\n" +
                    "•\tAminas primarias: rimantadina y amantadina. Estos fármacos bloquean una proteína del virus de la influenza, la M2. Esta proteína se encuentra exclusivamente en el tipo A del virus, por lo que estos fármacos no son eficaces para la gripe causada por el virus tipo B.\n" +
                    "\n" +
                    "•\tLa rimantidina tomada unas 48 horas después de que aparezcan los primeros síntomas reduce la duración de la fiebre y el malestar. La amantadina también disminuye los días de molestias, pero tiene efectos secundarios acusados, como dolor de cabeza e insomnio.\n");
        }
        else if(b.getString("sintoma").equals("Resfriado")){
            lblDetallesSintoma.setText("El tratamiento de los síntomas no hará desaparecer el resfriado, pero le ayudará a sentirse mejor. Los antibióticos casi nunca se necesitan para tratar un resfriado común.\n" +
                    "El paracetamol (Tylenol) y el ibuprofeno (Advil, Motrin) ayudan a disminuir la fiebre y aliviar los dolores musculares.  \n" +
                    "•\tNO use ácido acetilsalicílico (aspirin).  \n" +
                    "•\tVerifique en la etiqueta la dosis adecuada.  \n" +
                    "•\tLlame al médico si necesita tomar estos medicamentos más de 4 veces al día o por más de 2 o 3 días.\n");
        }
        else if(b.getString("sintoma").equals("Salpullido")){
            lblDetallesSintoma.setText("•\tEvite restregarse la piel.\n" +
                    "•\tUtilice la menor cantidad de jabón posible y use en su lugar productos de limpieza suaves.\n" +
                    "•\tEvite aplicar lociones o ungüentos cosméticos directamente sobre el salpullido.\n" +
                    "•\tUtilice agua tibia (no caliente) para la limpieza y seque dando palmaditas (no frotando).\n" +
                    "•\tElimine cualquier tipo de cosméticos y lociones recientemente agregados.\n" +
                    "•\tDeje el área afectada expuesta al aire tanto como sea posible.\n" +
                    "•\tEnsaye la loción de calamina para los casos de problemas con hiedra, roble o zumaque venenoso, al igual que para otros tipos de dermatitis de contacto.\n");
        }
        else if(b.getString("sintoma").equals("Temperatura")){
            lblDetallesSintoma.setText("Temperatura");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_sintoma, menu);
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

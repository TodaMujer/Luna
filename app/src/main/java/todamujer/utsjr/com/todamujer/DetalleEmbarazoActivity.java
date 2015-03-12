package todamujer.utsjr.com.todamujer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetalleEmbarazoActivity extends ActionBarActivity {

    TextView lblEmba, lblDetalleEmba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_embarazo);

        lblEmba=(TextView)findViewById(R.id.LblEmba);
        lblDetalleEmba=(TextView)findViewById(R.id.LblDetallesEmba);

        Bundle b=this.getIntent().getExtras();

        lblEmba.setText(b.getString("emba"));

         if(b.getString("emba").equals("Mes 1")){
            lblDetalleEmba.setText("Para muchas mujeres, el primer síntoma de embarazo es la falta del periodo menstrual. \n" +
                    "La mayoría de las pruebas de embarazo darán un resultado positivo para cuando la mujer no haya\n" +
                    "tenido el periodo menstrual. Otros síntomas iniciales de embarazo incluyen fatiga, sentirse hinchada, \n" +
                    "ganas frecuentes de orinar, cambios en el estado de ánimo, náuseas, y sensibilidad o hinchazón de los \n" +
                    "senos. No todas las mujeres tienen todos estos síntomas, pero es común tener, por lo menos, uno de ellos. \n");
         }
         else if(b.getString("emba").equals("Mes 2")){
             lblDetalleEmba.setText("El segundo mes es cuando los síntomas del embarazo se vuelven muy notorios.  Suelen empeorar los malestares comunes, como la sensibilidad en los senos, la fatiga, las ganas frecuentes de orinar, la acidez, las náuseas y los vómitos. El cuerpo de la mujer produce más sangre durante el embarazo y su corazón late más rápido y fuerte que lo normal para transportar esa sangre.");
         }
         else if(b.getString("emba").equals("Mes 3")){
             lblDetalleEmba.setText("Continúan muchos de los síntomas del embarazo de los dos primeros meses y, a veces, empeoran durante el tercer mes. En especial, las náuseas. Los senos de la mujer siguen creciendo y cambiando. La zona de alrededor del pezón, la aréola, puede agrandarse y oscurecerse. Las mujeres propensas al acné pueden tener erupciones.\n" +
                     "Las mujeres no suelen aumentar mucho de peso en los primeros tres meses del embarazo; por lo general, sólo alrededor de dos libras (0.90718474 kg). Las mujeres que tienen sobrepeso o que son muy delgadas pueden tener una tasa de aumento de peso diferente. Consulta con tu proveedor de atención de la salud acerca de cómo mantener un peso saludable durante el transcurso del embarazo.\n");
         }
         else if(b.getString("emba").equals("Mes 4")){
             lblDetalleEmba.setText("Algunos de los primeros síntomas del embarazo comienzan a aliviarse durante el cuarto mes. Suelen reducirse las náuseas. Pero otros problemas digestivos, como la acidez y el estreñimiento, pueden causar molestias. Suelen continuar los cambios en los senos, como el crecimiento, la hinchazón y el oscurecimiento de la aréola. Es común que la mujer tenga dificultad para respirar o que respire más rápido. El flujo sanguíneo ha aumentado y puede causar otros síntomas del embarazo, como el sangrado de las encías, de la nariz o congestión nasal. Las mujeres embarazadas pueden sentir mareos o desvanecimiento, debido a los cambios en la sangre y en los vasos sanguíneos.");
         }
         else if(b.getString("emba").equals("Mes 5")){
             lblDetalleEmba.setText("La mujer suele sentir los movimientos del feto por primera vez durante el quinto mes. Se puede sentir como revoloteos o mariposas en el estómago. Se sienten los movimientos del feto.\n" +
                     "Los síntomas del embarazo del cuarto mes continúan este mes. La acidez, el estreñimiento, los cambios en los senos, los mareos, la dificultad para respirar, las hemorragias nasales y de las encías son comunes. Los senos pueden ser hasta dos talles más grandes en este momento.\n");
         }
         else if(b.getString("emba").equals("Mes 6")){
             lblDetalleEmba.setText("Suelen continuar los síntomas del embarazo del cuarto y quinto mes. Puede mejorar la dificultad para respirar. Los senos pueden comenzar a producir calostro (pequeñas gotas de la primera leche). Esto puede continuar durante el transcurso del embarazo.\n" +
                     "Algunas mujeres tienen contracciones de Braxton-Hicks. Se sienten como una presión sin dolor del útero o el abdomen. Ésta es la manera en que el útero se prepara para el trabajo de parto y el parto en sí. Las contracciones de Braxton-Hicks son normales y no son un síntoma de trabajo de parto prematuro. Sin embargo, si las mujeres tienen dolor o contracciones frecuentes o si tienen dudas al respecto, deben consultar con el proveedor de atención de la salud.\n");
         }
         else if(b.getString("emba").equals("Mes 7")){
             lblDetalleEmba.setText("El útero de la mujer se sigue expandiendo. Es normal el dolor de espalda. Los síntomas del embarazo de los meses previos continúan. Los mareos pueden disminuir.");
         }
         else if(b.getString("emba").equals("Mes 8")){
             lblDetalleEmba.setText("Las mujeres, con frecuencia, comienzan a sentirse cansadas y se les hace más difícil respirar, ya que el útero se expande hacia arriba. Pueden tener várices, venas hinchadas rojizas o azuladas generalmente en las piernas, o hemorroides, várices en el recto. Las hemorroides pueden ser dolorosas, picar y hasta sangrar. La mujer también puede tener estrías donde se estiró la piel. Las contracciones de Braxton-Hicks, la acidez y el estreñimiento pueden continuar. Se les puede escapar un poco de orina al estornudar o al reírse, ya que el útero presiona la vejiga. Las hormonas pueden hacer que el cabello tenga más volumen y esté más saludable.");
         }
         else if(b.getString("emba").equals("Mes 9")){
             lblDetalleEmba.setText("A finales del embarazo, el útero se ha expandido desde la pelvis de la mujer hasta la parte inferior de la caja torácica. Los síntomas del embarazo en el décimo mes dependen en gran medida de cuándo el feto desciende a la parte más baja del útero en la pelvis.\n" +
                     "La dificultad para respirar, la acidez y el estreñimiento generalmente mejoran cuando el feto desciende. Pero la posición del feto más baja en la pelvis genera ganas frecuentes de orinar y problemas para contener la orina.\n" +
                     "El cuello del útero comenzará a abrirse y dilatarse para prepararse para el parto. Esto puede suceder unas pocas semanas antes del parto o podría empezar cuando una mujer entra en trabajo de parto. La mujer puede sentir dolores punzantes en la vagina a medida que el cuello del útero se dilata.\n" +
                     "Luego de dar a luz al recién nacido, la placenta y otros tejidos también salen del cuerpo de la mujer. Esto se denomina \"alumbramiento\"\n");
         }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_embarazo, menu);
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

package todamujer.utsjr.com.todamujer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetalleHumorActivity extends ActionBarActivity {
    TextView lblHumor, lblDetallesHumor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_humor);

        lblHumor=(TextView)findViewById(R.id.LblHumor);
        lblDetallesHumor=(TextView)findViewById(R.id.LblDetallesHumor);


        Bundle b=this.getIntent().getExtras();

        lblHumor.setText(b.getString("humor"));

        if(b.getString("humor").equals("Feliz")){
            lblDetallesHumor.setText("1 Ver la cara que pone tu esposo cuando le muestras la rayita del resultado positivo en la prueba de embarazo. \n" +
                    "\n" +
                    "2 Disfrutar de las primeras semanas, cuando el embarazo es un precioso secreto entre tu pareja y tú. \n" +
                    "\n" +
                    "3 Saber que tienes nueve meses enteros para planear, soñar y fantasear. \n" +
                    "\n" +
                    "4 Escoger ropa de maternidad. Hoy en día es bonita, práctica, ¡e incluso sexy! \n" +
                    "\n" +
                    "5 Tener la excusa perfecta para consentirte: darte largos baños perfumados, disfrutar un masaje especial para embarazadas y ponerte cremas hidratantes en la pancita. \n");

        }
        else if(b.getString("humor").equals("Inspirada")){
            lblDetallesHumor.setText("Toma una pausa y camina por 10 minutos\n" +
                    "Escucha música del mundo, sal de lo que escuchas diario\n" +
                    "Lee algún blog o artículo\n" +
                    "Evita las redes sociales por algún tiempo\n" +
                    "Dibuja aunque no sepas\n" +
                    "¡Escribe!\n" +
                    "Regálate 20 minutos y lee un poco de ese libro que no has continuado\n" +
                    "Respira profundamente por 3 minutos\n" +
                    "Medita por 10 minutos, diariamente\n" +
                    "Toma una taza de café");
        }
        else if(b.getString("humor").equals("Molesta")){
            lblDetallesHumor.setText("Recarga la pila familiar y llama a tu madre\n" +
                    "Lee un cómic\n" +
                    "Aléjate de la computadora por 30 minutos\n" +
                    "Cuando estés en casa, evita la televisión\n" +
                    "¡Apaga el teléfono móvil!\n" +
                    "Haz una lista de pendientes realista. Comienza actuando por las tareas cortas\n" +
                    "Habla con algún amigo\n" +
                    "Busca personas positivas, que te motiven, y habla con ellas\n" +
                    "Deja de quejarte\n" +
                    "¡Hazlo un día a la vez!");
        }
        else if(b.getString("humor").equals("Furiosa")){
            lblDetallesHumor.setText("Respire profundamente, desde su diafragma. Respirar desde su pecho no lo relajará. Imagine que su respiración sube desde su \"barriga.\" Lentamente repita una palabra o frase tranquilizadora como \"relájate\" o \"tómalo con calma.\" Repítala mientras respira profundamente. Recurra a la imaginería; visualice una experiencia relajante sea de su memoria o imaginación. Los ejercicios lentos y no extenuantes como el yoga pueden relajar sus músculos y hacer que se calme. Practique estas técnicas a diario. Aprenda a usarlas automáticamente cuando se encuentre en una situación de tensión.");
        }
        else if(b.getString("humor").equals("Triste")){
            lblDetallesHumor.setText("Libérate de los pensamientos que te perjudican. Liberar pensamientos negativos es sencillo, puedes escribirlos en un papel o llamar a una persona con la que tengas confianza y puedas comunicarte bien para contárselo, ¿quién sabe? Quizá te ayude a ver las cosas desde otra perspectiva mejor.");
        }
        else if(b.getString("humor").equals("Muy triste")){
            lblDetallesHumor.setText("Tienes que saber que pronto vendrán grandes alegrías a tu vida, solo ahora que estas pasando por un momento difícil es hora de levantarte y seguir, y es que nunca hay un amanecer sin largas horas de oscuridad");
             }
        else if(b.getString("humor").equals("Sorprendida")){
            lblDetallesHumor.setText("Encontrar personas que te ofrecen su asiento en el metro y el autobús. \n" +
                    "\n" +
                    "Ver cómo se les ilumina el rostro a tu mamá, papá, hermanos y amigos cuando les das la buena noticia. \n" +
                    "\n" +
                    "Aprender cosas nuevas, desde tejer un minúsculo suetercito hasta cómo compartir fotos por computadora, para que el mundo entero pueda conocer a tu recién nacido. \n" +
                    "\n" +
                    "Sentir que tu sensibilidad es más aguda que nunca, que tus lágrimas brotan con más frecuencia y que tu capacidad de amar crece cada día. \n" +
                    "\n" +
                    "Decorar la recámara de tu bebé o un rinconcito de tu propio dormitorio. \n");
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_humor, menu);
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

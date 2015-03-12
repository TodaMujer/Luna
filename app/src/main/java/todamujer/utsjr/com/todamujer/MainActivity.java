package todamujer.utsjr.com.todamujer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {




    private static final int MENU_MENU=1;
    private static final int MENU_AYUDA=2;
    private static final int MENU_FAVORITO=3;
    private static final int MENU_CONOCENOS=34;

    private static final int SUBMENU_MENU_CALENDARIO=11;
    private static final int SUBMENU_MENU_SINTOMAS=12;
    private static final int SUBMENU_MENU_HUMOR=13;
    private static final int SUBMENU_MENU_EMBARAZO=14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);


        menu.add(Menu.NONE,MENU_MENU,Menu.NONE,"Menu");



        menu.add(Menu.NONE,MENU_AYUDA,Menu.NONE,"Ayuda");
        menu.add(Menu.NONE,MENU_FAVORITO,Menu.NONE,"Favoritos");
        menu.add(Menu.NONE,MENU_CONOCENOS,Menu.NONE,"Conocenos");




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){

            case MENU_MENU:
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                return true;

            case MENU_CONOCENOS:return true;
            case MENU_AYUDA:return true;
            case MENU_FAVORITO: return true;
            default: return super.onOptionsItemSelected(item);
        }



    }
}

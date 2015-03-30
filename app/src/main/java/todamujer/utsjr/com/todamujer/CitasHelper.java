package todamujer.utsjr.com.todamujer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alumno on 25/03/2015.
 */
public class CitasHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME="citas.db";
        private static final int DATABASE_VERSION=1;


        public CitasHelper(Context context){

            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+CitasTable.TABLA+"("+
                    CitasTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CitasTable.FECHA + " TEXT, "+
                    CitasTable.HORA + " TEXT, "+
                    CitasTable.NOMBRE + " TEXT, "+
                    CitasTable.TIPO + " TEXT, "+
                    CitasTable.NUMERO + " TEXT)"+
                    CitasTable.UBICACION+ " TEXT, ");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w(CitasHelper.class.getName(),
                    "Actualizacion base de datos de la version " + oldVersion +
                            " a " + newVersion + ", y se perderan los datos");

            db.execSQL("DROP TABLE IF EXIST "+CitasTable.TABLA);
            onCreate(db);
        }
    }



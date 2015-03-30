package todamujer.utsjr.com.todamujer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 25/03/2015.
 */
public class CitasDAO {

    private CitasHelper ch;
    private SQLiteDatabase sd;

    public CitasDAO(Context context){
        ch=new CitasHelper(context);
    }
    public void open() throws SQLException {
        sd=ch.getWritableDatabase();
    }

    public void close() {
        ch.close();
    }


    public SQLiteDatabase getSd(){
        return sd;
    }


    public boolean agregarCitas(Citas c){
        long resultado=-1;

        //declaramos objeto ContentValues
        ContentValues cv=new ContentValues();

        //agregamos elementos al ContentValues (clave,valor)
        cv.put(CitasTable.FECHA,c.getFecha());
        cv.put(CitasTable.HORA,c.getHora());
        cv.put(CitasTable.NOMBRE,c.getNombre());
        cv.put(CitasTable.TIPO,c.getTipo());
        cv.put(CitasTable.NUMERO,c.getNumero());
        cv.put(CitasTable.UBICACION,c.getUbicacion());

        //insertamos los valores en la tabla de la BD
        resultado=getSd().insert(CitasTable.TABLA,CitasTable.TABLA,cv);

        //verificar numero de filas afectadas
        if(resultado>0){
            return true;
        }
        else{
            return false;
        }


    }

    public boolean eliminarCitas(int id){
        long resultado=getSd().delete(CitasTable.TABLA,CitasTable.ID + "=" + id,null);

        //verificar numero de filas afectadas
        if(resultado>0){
            return true;
        }
        else{
            return false;
        }

    }

    //metodo para modificar un contacto
    public boolean modificarCitas(Citas m){
        long resultado=-1;

        //declaramos objeto ContentValues
        ContentValues cv=new ContentValues();

        //agregamos elementos al ContentValues (clave,valor)
        cv.put(CitasTable.FECHA,m.getFecha());
        cv.put(CitasTable.HORA,m.getHora());
        cv.put(CitasTable.NOMBRE,m.getNombre());
        cv.put(CitasTable.TIPO,m.getTipo());
        cv.put(CitasTable.NUMERO,m.getNumero());
        cv.put(CitasTable.UBICACION,m.getUbicacion());

        //se actualiza l registro
        resultado=getSd().update(CitasTable.TABLA,cv,CitasTable.ID + "=?",new String[]{String.valueOf(m.getId())});


        //verificar numero de filas afectadas
        if(resultado>0){
            return true;
        }
        else{
            return false;
        }

    }

    //metodo para obtener una lista de todos los contactos

    public List<Citas> getCitas(){
        Citas m=null;
        List<Citas> contactosList=new ArrayList<Citas>();
        //declaramos un objeto Cursor y obtenemos los datos
        Cursor cursor=getSd().query(CitasTable.TABLA,CitasTable.getCitasColumns(),null,null,null,null,null);

        //nos moveremos al primer elemento del cursor
        cursor.moveToFirst();

        //recorremos el cursor y vamos extrayendo cada registro
        //y agregandolo a la lista
        while (!cursor.isAfterLast()){
            m=new Citas();
            m.setId(cursor.getInt(0));
            m.setFecha(cursor.getString(1));
            m.setHora(cursor.getString(2));
            m.setNombre(cursor.getString(3));
            m.setTipo(cursor.getString(4));
            m.setNumero(cursor.getString(5));
            m.setUbicacion(cursor.getString(6));
            contactosList.add(m);
            cursor.moveToNext();
        }
        return contactosList;
    }

    //metodo para buscar un solo contacto por si ID
    public Citas buscarCitas(int id){
        //convertimos el id que es int a un arreglo de string
        String[] valor={String.valueOf(id)};

        //declaramos el cursor y hacemos la consulta
        Cursor cursor=getSd().query(CitasTable.TABLA,CitasTable.getCitasColumns(),"id=?",valor,null,null,null);


        cursor.moveToFirst();
        Citas m=new Citas();
        m.setId(cursor.getInt(0));
        m.setFecha(cursor.getString(1));
        m.setHora(cursor.getString(2));
        m.setNombre(cursor.getString(3));
        m.setTipo(cursor.getString(4));
        m.setNumero(cursor.getString(5));
        m.setUbicacion(cursor.getString(5));

        return m;
    }


    //metodo que nos obtiene una lista de los nokmbres de los contactos

    public List<String> getNombreCitas(){
        List<String> nombresList=new ArrayList<String>();
        //declaramos el cursor y obtenemos los registros
        Cursor cursor=getSd().query(CitasTable.TABLA,CitasTable.getCitasColumns(),null,null,null,null,null);
        cursor.moveToFirst();

        //recorremo el cursor y extraemos el compo NOMBRE
        while(!cursor.isAfterLast()){
            nombresList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        return nombresList;
    }

    //metodo para obtener lista de los ID de los contactos
    public List<String> getIdCitas(){
        List<String> idList=new ArrayList<String>();


        //declaramos el cursor y obtenemos los registros
        Cursor cursor=getSd().query(CitasTable.TABLA,CitasTable.getCitasColumns(),null,null,null,null,null);
        cursor.moveToFirst();



        //recorremo el cursor y extraemos el compo NOMBRE
        while(!cursor.isAfterLast()){
            idList.add(""+cursor.getString(0));
            cursor.moveToNext();
        }
        return idList;




    }



}

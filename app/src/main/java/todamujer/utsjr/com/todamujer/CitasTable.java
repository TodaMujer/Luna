package todamujer.utsjr.com.todamujer;

/**
 * Created by Alumno on 25/03/2015.
 */
public class CitasTable {
    public static final String TABLA="citas";
    public static final String ID="id";
    public static final String FECHA="fecha";
    public static final String HORA="hora";
    public static final String NOMBRE="nombre";
    public static final String TIPO="tipo";
    public static final String NUMERO="numero";
    public static final String UBICACION="ubicacion";
    ;

    public static String[] getCitasColumns(){
        String array[]={ID,FECHA,HORA,NOMBRE,TIPO,NUMERO,UBICACION};
        return array;
    }

}



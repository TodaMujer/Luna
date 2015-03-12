package todamujer.utsjr.com.todamujer;

/**
 * Created by yonathan on 13/02/2015.
 */
public class Item {

    //atributos de la clase
    private int imagen;
    private String sintoma;

    public Item(int imagen, String sintoma) {
        super();
        this.imagen = imagen;
        this.sintoma = sintoma;
    }

    //metodos de acceso


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
}

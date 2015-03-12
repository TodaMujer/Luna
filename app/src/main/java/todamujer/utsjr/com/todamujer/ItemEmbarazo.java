package todamujer.utsjr.com.todamujer;

/**
 * Created by yonathan on 08/03/2015.
 */
public class ItemEmbarazo {

    private int imagenEmba;
    private String emba;

    public ItemEmbarazo(int imagenEmba, String emba) {
        this.imagenEmba = imagenEmba;
        this.emba = emba;
    }

    public int getImagenEmba() {
        return imagenEmba;
    }

    public void setImagenEmba(int imagenEmba) {
        this.imagenEmba = imagenEmba;
    }

    public String getEmba() {
        return emba;
    }

    public void setEmba(String emba) {
        emba = emba;
    }
}

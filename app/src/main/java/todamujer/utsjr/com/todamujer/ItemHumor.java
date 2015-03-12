package todamujer.utsjr.com.todamujer;

/**
 * Created by yonathan on 04/03/2015.
 */
public class ItemHumor {

    private int imagenHumor;
    private String humor;

    public ItemHumor(int imagenHumor, String humor) {
        this.imagenHumor = imagenHumor;
        this.humor = humor;
    }

    public int getImagenHumor() {
        return imagenHumor;
    }

    public void setImagenHumor(int imagenHumor) {
        this.imagenHumor = imagenHumor;
    }

    public String getHumor() {
        return humor;
    }

    public void setHumor(String humor) {
        this.humor = humor;
    }
}

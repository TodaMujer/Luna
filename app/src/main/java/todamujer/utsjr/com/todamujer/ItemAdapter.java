package todamujer.utsjr.com.todamujer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by yonathan on 13/02/2015.
 */
public class ItemAdapter extends BaseAdapter{


    //atributos de la clase
    private Context context;
    private List<Item> items;

    //constructor
    public ItemAdapter(Context context, List<Item> items) {
        super();
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=convertView;

        if(convertView==null){
            //creamos una vista en la ListView
            LayoutInflater inflater=(LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView=inflater.inflate(R.layout.list_item,parent,false);
        }

        //colocamos los valores en la vista

        ImageView imgItem=(ImageView)rowView.findViewById(R.id.ImgItem);
        TextView lblSintoma=(TextView)rowView.findViewById(R.id.LblSintoma);

        Item item=this.items.get(position);
        lblSintoma.setText(item.getSintoma());
        imgItem.setImageResource(item.getImagen());


        return rowView;

    }
}

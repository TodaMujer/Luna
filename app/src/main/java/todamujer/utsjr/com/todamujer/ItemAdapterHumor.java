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
 * Created by yonathan on 04/03/2015.
 */
public class ItemAdapterHumor extends BaseAdapter {

    private Context context;
    private List<ItemHumor> items;

    public ItemAdapterHumor(Context context, List<ItemHumor> items) {
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
            rowView=inflater.inflate(R.layout.list_item_humor,parent,false);
        }

        //colocamos los valores en la vista

        ImageView imgItemHumor=(ImageView)rowView.findViewById(R.id.ImgItemHumor);
        TextView lblHumor=(TextView)rowView.findViewById(R.id.LblHumor);


        ItemHumor itemHumor=this.items.get(position);
        lblHumor.setText(itemHumor.getHumor());
        imgItemHumor.setImageResource(itemHumor.getImagenHumor());


        return rowView;
    }
}

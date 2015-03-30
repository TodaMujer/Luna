package todamujer.utsjr.com.todamujer;


import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alumno on 25/03/2015.
 */
public class AdaptadorCitas extends BaseAdapter {


    //atributos
    private static ArrayList<Citas> searchArrayList;
    private LayoutInflater mInflater;


    //constructor
    public AdaptadorCitas(Context context,ArrayList<Citas> results) {
        searchArrayList=results;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return searchArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView==null){
            convertView=mInflater.inflate(R.layout.list_item_citas,null);
            holder=new ViewHolder();
            holder.txtFecha=(TextView) convertView.findViewById(R.id.LblFecha);
            holder.txtTipo=(TextView) convertView.findViewById(R.id.LblTipo);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }

        holder.txtFecha.setText(searchArrayList.get(position).getFecha());
        holder.txtTipo.setText(searchArrayList.get(position).getTipo());



        return convertView;
    }

    static class ViewHolder{
        TextView txtFecha, txtTipo;
    }
}



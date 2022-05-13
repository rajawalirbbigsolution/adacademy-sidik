package com.app.adacademy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.app.adacademy.R;
import com.app.adacademy.model.MasterKordinat;

import java.util.ArrayList;

public class AdapterKordinat extends BaseAdapter {
    private final Context context;
    private final ArrayList<MasterKordinat> listDataRute;

    public AdapterKordinat(Context context, int resource, ArrayList<MasterKordinat> showMasterRute) {
        this.context = context;
        this.listDataRute = showMasterRute;
    }

    @Override
    public int getCount() {
        return listDataRute.size();
    }

    @Override
    public Object getItem(int position) {
        return listDataRute.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.list_home, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        try {
            holder.vNameRute.setText(String.valueOf(listDataRute.get(position).getName()));
            if (listDataRute.get(position).getName().equals("Monas")){
                holder.iconLandMark.setImageResource(R.drawable.oval_landmark);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

    private class ViewHolder {

        private TextView vNameRute;
        private ImageView iconLandMark;


        public ViewHolder(View v) {
            vNameRute = (TextView) v.findViewById(R.id.tv_rute_name);
             iconLandMark = (ImageView)v.findViewById(R.id.list_item_icon);
        }
    }
}

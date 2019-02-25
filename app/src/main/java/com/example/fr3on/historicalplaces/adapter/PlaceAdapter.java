package com.example.fr3on.historicalplaces.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fr3on.historicalplaces.R;
import com.example.fr3on.historicalplaces.model.place;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {

    public static final String PREF_FILE = "com.historicalplaces.prefrences";
    ArrayList<place> places ;
    Context context;

    public PlaceAdapter(ArrayList<place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View v =convertView;
        if(convertView==null)
            v = LayoutInflater.from(context).inflate(R.layout.list_item_place,parent,false);
        ((ImageView)v.findViewById(R.id.imageView)).setImageResource(places.get(position).getImage());
        ((TextView)v.findViewById(R.id.titleTextView)).setText(places.get(position).getName());
        ((TextView)v.findViewById(R.id.ratingTextView)).setText(String.format("%s: %d",context.getString(R.string.rating)
                ,places.get(position).getRate()));

        final place current_place =places.get(position);
        final TextView ratingTextView = ((TextView)v.findViewById(R.id.ratingTextView));
        v.findViewById(R.id.rateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_place.setRate(current_place.getRate()+1);
                ratingTextView.setText(String.format("%s: %d",context.getString(R.string.rating)
                        ,current_place.getRate()));
                SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE);
                sharedPreferences.edit().putInt(current_place.getName(),current_place.getRate()).apply();
            }
        });
        return v;
    }
}

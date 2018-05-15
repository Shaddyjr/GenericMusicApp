package com.example.asc_guest.genericmusicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {
    GenreAdapter(Activity context, ArrayList<Genre> genres){
        super(context, 0, genres);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View genreView = convertView;
        if(genreView == null) {
            genreView = LayoutInflater.from(getContext()).inflate(R.layout.artist_or_genre, parent, false);
        }

        setBackgroundColor(genreView, position);

        Genre genreObj = getItem(position);

        TextView name = genreView.findViewById(R.id.name);
        name.setText(genreObj.getName());

        return genreView;
    }

    private void setBackgroundColor(View v, int position){
        int[] rainbowColors = getContext().getResources().getIntArray(R.array.rainbowColors);
        int randomAndroidColor = rainbowColors[position % rainbowColors.length];
        v.setBackgroundColor(randomAndroidColor);
    }
}

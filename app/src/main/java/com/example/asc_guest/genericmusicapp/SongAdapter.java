package com.example.asc_guest.genericmusicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SongAdapter extends ArrayAdapter<Song> {
    SongAdapter(Activity context, ArrayList<Song> songs){
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        // this will be the view that get's modified and populated with information from object at
        // ArrayList position
        View singleSongView = convertView;
        if(singleSongView == null) {
            singleSongView = LayoutInflater.from(getContext()).inflate(R.layout.single_song, parent, false);
        }

        setBackgroundColor(singleSongView, position);

        // after view recycled or inflated, securing object at position
        Song songObj = getItem(position);

        // now, filling in view with information from the object
        TextView artist = singleSongView.findViewById(R.id.songArtist);
        String artistString = getContext().getString(R.string.songArtist, songObj.getArtist());
        artist.setText(artistString);

        TextView genre = singleSongView.findViewById(R.id.songGenre);
        String genreString = getContext().getString(R.string.songGenre, songObj.getGenre());
        genre.setText(genreString);

        TextView title = singleSongView.findViewById(R.id.songName);
        title.setText(songObj.getTitle());

        TextView duration = singleSongView.findViewById(R.id.songDuration);
        duration.setText(songObj.getDuration());

        return singleSongView;
    }

    private void setBackgroundColor(View v, int position){
        int[] rainbowColors = getContext().getResources().getIntArray(R.array.rainbowColors);
        int randomAndroidColor = rainbowColors[position % rainbowColors.length];
        v.setBackgroundColor(randomAndroidColor);
    }
}

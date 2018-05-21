package com.example.asc_guest.genericmusicapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SongAdapter extends ArrayAdapter<Song> {
    Activity mActivity;
    SongAdapter(Activity context, ArrayList<Song> songs){
        super(context, 0, songs);
        mActivity = context;
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

        // after view recycled or inflated, securing object at position
        final Song song = getItem(position);

        // now, filling in view with information from the object
        TextView artist = singleSongView.findViewById(R.id.songArtist);
        String artistString = getContext().getString(R.string.songArtist, song.getArtist());
        artist.setText(artistString);

        TextView genre = singleSongView.findViewById(R.id.songGenre);
        String genreString = getContext().getString(R.string.songGenre, song.getGenre());
        genre.setText(genreString);

        TextView title = singleSongView.findViewById(R.id.songName);
        title.setText(song.getTitle());

        TextView duration = singleSongView.findViewById(R.id.songDuration);
        duration.setText(song.getDuration());

        Button play = singleSongView.findViewById(R.id.songPlayButton);
        setLightBackground(play, position);

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mActivity, PlayingSongActivity.class);
                intent.putExtra("name",song.getTitle());
                mActivity.startActivity(intent);
            }
        });


        setBackgroundColor(singleSongView, position);
        return singleSongView;
    }

    private void setBackgroundColor(View v, int position){
        int[] rainbowColors = getContext().getResources().getIntArray(R.array.rainbowColors);
        v.setBackgroundColor(rainbowColors[position % rainbowColors.length]);
    }

    private void setLightBackground(Button b, int position){
        int[] rainbowColorsLight = getContext().getResources().getIntArray(R.array.rainbowColorsLight);
        b.setBackgroundColor(rainbowColorsLight[position % rainbowColorsLight.length]);
        b.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
    }
}

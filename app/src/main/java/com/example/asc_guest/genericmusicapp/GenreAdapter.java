package com.example.asc_guest.genericmusicapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {
    private Activity mActivity;

    GenreAdapter(Activity context, ArrayList<Genre> genres){
        super(context, 0, genres);
        mActivity = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View genreView = convertView;
        if(genreView == null) {
            genreView = LayoutInflater.from(getContext()).inflate(R.layout.artist_or_genre, parent, false);
        }

        Genre genreObj = getItem(position);

        TextView name = genreView.findViewById(R.id.name);
        name.setText(genreObj.getName());

        LinearLayout songContainer = genreView.findViewById(R.id.songs);

        // need to clear out any previous views
        songContainer.removeAllViews();

        LayoutInflater inflater = LayoutInflater.from(songContainer.getContext());

        // adding children
        for(final Song song : genreObj.getSongs()){
            View child = inflater.inflate(R.layout.single_song, songContainer, false);

            TextView artist = child.findViewById(R.id.songArtist);
            String artistString = getContext().getString(R.string.songArtist, song.getArtist());
            artist.setText(artistString);

            TextView genre = child.findViewById(R.id.songGenre);
            String genreString = getContext().getString(R.string.songGenre, song.getGenre());
            genre.setText(genreString);

            TextView title = child.findViewById(R.id.songName);
            title.setText(song.getTitle());

            TextView duration = child.findViewById(R.id.songDuration);
            duration.setText(song.getDuration());

            Button play = child.findViewById(R.id.songPlayButton);
            setBackgroundColor(play, position);

            play.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(mActivity, PlayingSongActivity.class);
                    intent.putExtra("name",song.getTitle());
                    mActivity.startActivity(intent);
                }
            });

            setSongBackground(child, position);
            songContainer.addView(child);
        }
        setBackgroundColor(genreView, position);
        return genreView;
    }

    private void setBackgroundColor(View v, int position){
        int[] rainbowColors = getContext().getResources().getIntArray(R.array.rainbowColors);
        v.setBackgroundColor(rainbowColors[position % rainbowColors.length]);
    }

    private void setSongBackground(View v, int position){
        int[] rainbowColorsLight = getContext().getResources().getIntArray(R.array.rainbowColorsLight);
        v.setBackgroundColor(rainbowColorsLight[position % rainbowColorsLight.length]);
    }
}

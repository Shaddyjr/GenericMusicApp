package com.example.asc_guest.genericmusicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    ArtistAdapter(Activity context, ArrayList<Artist> artists){
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View artistView = convertView;
        if(artistView == null) {
            artistView = LayoutInflater.from(getContext()).inflate(R.layout.artist_or_genre, parent, false);
        }

        setBackgroundColor(artistView, position);

        Artist artistObj = getItem(position);

        TextView name = artistView.findViewById(R.id.name);
        name.setText(artistObj.getName());

        LinearLayout songContainer = artistView.findViewById(R.id.songs);
        // adding children
        for(Song song : artistObj.getSongs()){
            View child = View.inflate(getContext(),R.layout.single_song,null);

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

            songContainer.addView(child);
        }
        return artistView;
    }

    private void setBackgroundColor(View v, int position){
        int[] rainbowColors = getContext().getResources().getIntArray(R.array.rainbowColors);
        int randomAndroidColor = rainbowColors[position % rainbowColors.length];
        v.setBackgroundColor(randomAndroidColor);
    }
}

package com.example.asc_guest.genericmusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ArtistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_and_genre);

        ArtistAdapter artistAdapter = new ArtistAdapter(this, MusicPlayer.artists());

        ListView artistOrGenreListView = findViewById(R.id.artist_or_genre_activity);

        artistOrGenreListView.setAdapter(artistAdapter);
    }
}

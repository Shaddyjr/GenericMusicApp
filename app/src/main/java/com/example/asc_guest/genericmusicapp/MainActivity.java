package com.example.asc_guest.genericmusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView
            mAllSongsTextView,
            mByArtistTextView,
            mByGenreTextView,
            mRandomSongTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAllSongsTextView   = findViewById(R.id.allSongs);
        mByArtistTextView   = findViewById(R.id.byArtist);
        mByGenreTextView    = findViewById(R.id.byGenre);
        mRandomSongTextView = findViewById(R.id.randomSong);

        new MusicPlayer(); // creates all songs

        mAllSongsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, AllSongsActivity.class));
            }
        });

        mByArtistTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ArtistActivity.class));
            }
        });

        mByGenreTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, GenreActivity.class));
            }
        });

        mRandomSongTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, PlayingSongActivity.class));
            }
        });
    }
}

package com.example.asc_guest.genericmusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllSongsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);

        SongAdapter songAdapter = new SongAdapter(this, MusicPlayer.songs());

        ListView singSongListView = findViewById(R.id.allSongsActivity);

        singSongListView.setAdapter(songAdapter);
    }
}

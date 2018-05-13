package com.example.asc_guest.genericmusicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    MusicPlayer mMusicPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMusicPlayer = new MusicPlayer();
        Log.v("main",mMusicPlayer.songs().get(0).getTitle());
        Log.v("main",mMusicPlayer.artists().get(0).getName());
        Log.v("main",mMusicPlayer.genres().get(0).getName());
    }
}

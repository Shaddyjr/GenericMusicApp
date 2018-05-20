package com.example.asc_guest.genericmusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayingSongActivity extends AppCompatActivity {
    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_song);

        mIntent = getIntent();
        if(mIntent.hasExtra("name")){
            songFill(Song.findByName(mIntent.getStringExtra("name")));
        }else{
            blankFill();
        }
    }

    private void songFill(Song song){

    }

    private void blankFill(){

    }
}

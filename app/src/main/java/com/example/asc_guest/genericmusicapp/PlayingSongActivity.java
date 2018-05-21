package com.example.asc_guest.genericmusicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlayingSongActivity extends AppCompatActivity {
    Intent mIntent;
    TextView
            mTitle,
            mGenre,
            mArtist,
            mDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_song);

        mTitle = findViewById(R.id.songName);
        mGenre = findViewById(R.id.songGenre);
        mArtist = findViewById(R.id.songArtist);
        mDuration = findViewById(R.id.songDuration);

        mIntent = getIntent();
        if(mIntent.hasExtra("name")){
            songFill(Song.findByName(mIntent.getStringExtra("name")));
        }else{
            blankFill();
        }
    }

    private void songFill(Song song){
        mTitle.setText(song.getTitle());
        mArtist.setText(song.getArtist());
        mGenre.setText(song.getGenre());
        mDuration.setText(song.getDuration());
    }

    private void blankFill(){
        String str = getResources().getString(R.string.blank);
        mTitle.setText(str);
        mArtist.setText(str);
        mGenre.setText(str);
        mDuration.setText(str);
    }
}

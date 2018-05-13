package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;

public class MusicPlayer {

    public MusicPlayer(){
        new Song("Blah","Blah Blah","Blah");
    }

    public ArrayList<Song> songs(){
        return Song.getAll();
    }

    public ArrayList<Genre> genres(){
        return Genre.getAll();
    }

    public ArrayList<Artist> artists(){
        return Artist.getAll();
    }
}

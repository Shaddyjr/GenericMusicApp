package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;

public class Song {
    static private ArrayList<Song> all = new ArrayList<Song>();

    private String artist;
    private String genre;
    private String title;

    public Song(String title, String artist, String genre){
        this.title = title;
        this.artist = artist;
        Artist.create(artist);

        this.genre = genre;
        Genre.create(genre);

        all.add(this);
    }

    public static ArrayList<Song> getAll() {
        return all;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }
}

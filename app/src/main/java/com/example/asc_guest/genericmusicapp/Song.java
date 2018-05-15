package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Responsible for interfacing with songs.
 */
public class Song {
    static private ArrayList<Song> all = new ArrayList<Song>();

    private String artist;
    private String genre;
    private String title;
    private double duration;

    /**
     * Constructor for song.
     * @param artist name of artist
     * @param duration duration of song
     * @param genre genre song belongs to
     * @param title title of song
     */
    Song(String artist, double duration, String genre, String title){
        this.title = title;
        this.duration = duration;

        this.artist = artist;
        Artist.create(artist);

        this.genre = genre;
        Genre.create(genre);

        all.add(this);
    }

    /**
     * Returns all songs created.
     * @return ArrayList
     */
    public static ArrayList<Song> getAll() {
        return all;
    }

    /**
     * Returns the song's artist.
     * @return String
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the song's genre.
     * @return String
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the song's title.
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the song's duration.
     * @return String
     */
    public String getDuration() {
        return String.format(Locale.US, "%.2f", duration/60);
    }
}

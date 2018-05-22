package com.example.asc_guest.genericmusicapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Responsible for interfacing with songs.
 */
public class Song implements Comparable{
    static private ArrayList<Song> all = new ArrayList<>();

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
        this.artist = Artist.createOrFind(artist, this).getName();
        this.genre = Genre.createOrFind(genre, this).getName();
        all.add(this);
    }

    /**
     * Returns all songs created.
     * @return ArrayList
     */
    public static ArrayList<Song> getAll() {
        Collections.sort(all);
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

    /**
     * Returns song found by name.
     * @param name name of song
     * @throws Error when song not found
     * @return Song
     */
    public static Song findByName(String name){
        for(Song song: all){
            if(song.getTitle().equals(name)){
                return song;
            }
        }
        throw new Error("Name not found: " + name);
    }

    /**
     * Returns random song name.
     * @return String
     */
    public static String randomSongName(){
        return all.get(new Random().nextInt(all.size())).getTitle();
    }
    @Override
    public int compareTo(@NonNull Object o) {
        return this.title.compareTo(((Song)o).getTitle());
    }
}

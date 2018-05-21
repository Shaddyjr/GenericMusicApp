package com.example.asc_guest.genericmusicapp;

import android.support.annotation.NonNull;
import android.util.Log;

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
    static private HashMap<String,Integer> hashRecord = new HashMap();

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
        if(!hashRecord.containsKey(title)){
            hashRecord.put(title,hashRecord.size());
            all.add(this);
            this.title = title;
            this.duration = duration;
            this.artist = Artist.createOrFind(artist, this).getName();
            this.genre = Genre.createOrFind(genre, this).getName();
        }
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
     * @return Song
     */
    public static Song findByName(String name){
        Log.v("blah", name);
        Log.v("blah2",""+hashRecord.get(name));
        return all.get(hashRecord.get(name)-1);
    }

    /**
     * Returns random song name.
     * @return String
     */
    public static String randomSongName(){
        return new ArrayList<>(hashRecord.keySet()).get(new Random().nextInt(hashRecord.size()));
    }
    @Override
    public int compareTo(@NonNull Object o) {
        return this.title.compareTo(((Song)o).getTitle());
    }
}

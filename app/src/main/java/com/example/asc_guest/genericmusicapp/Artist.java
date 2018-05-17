package com.example.asc_guest.genericmusicapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Responsible for interfacing with artists.
 */
public class Artist implements Comparable{
    static private ArrayList<Artist> all = new ArrayList<Artist>();
    static private HashMap<String,Integer> artistRecord = new HashMap();

    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    /**
     * Constructor for artist.
     * @param name name of artist
     */
    private Artist (String name, Song song){
        if(!artistRecord.containsKey(name)){
            artistRecord.put(name,artistRecord.size());
            all.add(this);
        }
        this.name = name;
        this.songs.add(song);
    }

    /**
     * Returns name of artist.
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * Returns songs.
     * @return ArrayList<Song>
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Returns all artists created.
     * @return ArrayList
     */
    public static ArrayList<Artist> getAll() {
        Collections.sort(all);
        return all;
    }

    /**
     * Will create artist, if it doesn't already exist.
     * @param name name of artist
     * @return Artist
     */
    public static Artist createOrFind(String name, Song song){
        Artist artist;
        if(!artistRecord.containsKey(name)){
            artist = new Artist(name, song);
        }else{
            artist = findByName(name);
            artist.songs.add(song);
        }
        return artist;
    }


    /**
     * Finds the Artist by name
     * @param name name of artist
     * @return Artist
     */
    private static Artist findByName(String name){
        return all.get(artistRecord.get(name));
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return this.name.compareTo(((Artist)o).getName());
    }
}

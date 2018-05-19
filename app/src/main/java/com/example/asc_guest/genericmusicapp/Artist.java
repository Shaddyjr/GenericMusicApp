package com.example.asc_guest.genericmusicapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Responsible for interfacing with artists.
 */
public class Artist extends SongGrouping{
    static private ArrayList<Artist> all = new ArrayList<>();
    static private HashMap<String,Integer> hashRecord = new HashMap();

    /**
     * Constructor for artist.
     * @param name name of artist
     */
    private Artist (String name, Song song){
        super(name, song);
        if(!hashRecord.containsKey(name)){
            hashRecord.put(name,hashRecord.size());
            all.add(this);
        }
        setName(name);
        getSongs().add(song);
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
         if(!hashRecord.containsKey(name)){
             artist = new Artist(name, song);
         }else{
             artist = findByName(name);
             artist.getSongs().add(song);
         }
         return artist;
     }

    /**
     * Finds the Artist by name
     * @param name name of artist
     * @return Artist
     */
    private static Artist findByName(String name){
        return all.get(hashRecord.get(name));
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return getName().compareTo(((Artist)o).getName());
    }
}

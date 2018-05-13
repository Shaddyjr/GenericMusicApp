package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;
/**
 * Responsible for interfacing with artists.
 */
public class Artist{
    static private ArrayList<Artist> all = new ArrayList<Artist>();

    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    /**
     * Constructor for artist.
     * @param name name of artist
     */
    private Artist (String name){
        this.name = name;
        Artist.all.add(this);
    }

    /**
     * Returns name of artist.
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * Returns all artists created.
     * @return ArrayList
     */
    public static ArrayList<Artist> getAll() {
        return all;
    }

    /**
     * Will create artist, if it doesn't already exist.
     * @param name name of artist
     * @return Artist
     */
    public static Artist create(String name){
        int index = Artist.findByName(name);
        if(index > 0) {
            return all.get(index);
        }
        return new Artist(name);
    }

    /**
     * Returns index of artist in .all ArrayList.
     * Returns -1 if not found.
     * @param name name of artist
     * @return int
     */
    private static int findByName(String name){
        int l = all.size();
        for(int i = 0; i < l ; i++){
            if(all.get(i).name.equals(name)){
                return i;
            }
        }
        return -1;
    }
}

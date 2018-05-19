package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;

public abstract class SongGrouping  implements Comparable{
    private ArrayList<Song> songs = new ArrayList<Song>();
    private String name;

    /**
     * Constructor for SongGrouping.
     * @param name name of SongGrouping
     */
    public SongGrouping (String name, Song song){}

    /**
     * Sets the name.
     * @param name name of SongGrouping
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns name.
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

    }

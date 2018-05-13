package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;
/**
 * Responsible for interfacing with genres.
 */
public class Genre {
    static private ArrayList<Genre> all = new ArrayList<Genre>();

    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    /**
     * Constructor for genre.
     * @param name name of genre
     */
    private Genre (String name){
        this.name = name;
        all.add(this);
    }
    /**
     * Returns name of genre.
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Returns all genres created.
     * @return
     */
    public static ArrayList<Genre> getAll() {
        return all;
    }

    /**
     * Will create genre, if it doesn't already exist.
     * @param name name of genre
     * @return
     */
    public static Genre create(String name){
        int index = Genre.findByName(name);
        if(index > 0) {
            return all.get(index);
        }
        return new Genre(name);
    }

    /**
     * Returns index of genre in .all ArrayList.
     * Returns -1 if not found.
     * @param name name of genre
     * @return
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

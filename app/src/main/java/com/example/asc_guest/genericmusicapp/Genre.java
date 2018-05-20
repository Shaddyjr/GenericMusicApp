package com.example.asc_guest.genericmusicapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Responsible for interfacing with genres.
 */
public class Genre extends SongGrouping{
    static private ArrayList<Genre> all = new ArrayList<>();
    static private HashMap<String,Integer> hashRecord = new HashMap();

    /**
     * Constructor for genre.
     * @param name name of genre
     */
    private Genre (String name, Song song){
        super(name, song);
        if(!hashRecord.containsKey(name)){
            hashRecord.put(name,hashRecord.size());
            all.add(this);
        }
        setName(capitalize(name));
        getSongs().add(song);
    }

    /**
     * Capitalizes the first letter for every letter in input str.
     * @param str string to convert
     * @return String
     */
    private String capitalize(String str) {
        char[] array = str.toCharArray();
        array[0] = Character.toUpperCase(array[0]);
        for(int i = 1; i<array.length; i++ ){
            if(array[i] == ' '){
                array[i+1]=Character.toUpperCase(array[i+1]);
            }
        }
        return new String(array);
    }

    /**
     * Returns all genres created.
     * @return String
     */
    public static ArrayList<Genre> getAll() {
        Collections.sort(all);
        return all;
    }

    /**
     * Will create genre, if it doesn't already exist.
     * @param name name of genre
     * @return Genre
     */
    public static Genre createOrFind(String name, Song song){
        Genre genre;
        if(!hashRecord.containsKey(name)) {
            genre = new Genre(name, song);
        }else{
            genre = findByName(name);
            genre.getSongs().add(song);
        }
        return genre;
    }

    /**
     * Finds the Genre by name
     * @param name name of genre
     * @return Genre
     */
    private static Genre findByName(String name){
        return all.get(hashRecord.get(name));
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return getName().compareTo(((Genre)o).getName());
    }
}

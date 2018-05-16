package com.example.asc_guest.genericmusicapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Responsible for interfacing with genres.
 */
public class Genre implements Comparable {
    static private ArrayList<Genre> all = new ArrayList<Genre>();
    static private HashMap<String,Integer> genreRecord = new HashMap();
    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    /**
     * Constructor for genre.
     * @param name name of genre
     */
    private Genre (String name, Song song){
        if(!genreRecord.containsKey(name)){
            genreRecord.put(name,genreRecord.size());
            all.add(this);
        }else{
            throw new Error("Genre already exists");
        }
        this.name = capitalize(name);
        this.songs.add(song);
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
     * Returns name of genre.
     * @return String
     */
    public String getName(){
        return name;
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
     * Finds the Genre by name
     * @param name name of genre
     * @return Genre
     */
    private static Genre findByName(String name){
        return all.get(genreRecord.get(name));
    }

    /**
     * Will create genre, if it doesn't already exist.
     * @param name name of genre
     * @return Genre
     */
    public static Genre createOrFind(String name, Song song){
        Genre genre;
        if(!genreRecord.containsKey(name)) {
            genre = new Genre(name, song);
        }else{
            genre = findByName(name);
            genre.songs.add(song);
        }
        return genre;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return this.name.compareTo(((Genre)o).getName());
    }
}

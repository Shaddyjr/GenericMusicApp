package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;

public class Genre {
    static private ArrayList<Genre> all = new ArrayList<Genre>();

    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    private Genre (String name){
        this.name = name;
        all.add(this);
    }

    public String getName(){
        return name;
    }

    public static ArrayList<Genre> getAll() {
        return all;
    }

    public static Genre create(String name){
        int index = Genre.findByName(name);
        if(index > 0) {
            return all.get(index);
        }
        return new Genre(name);
    }

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

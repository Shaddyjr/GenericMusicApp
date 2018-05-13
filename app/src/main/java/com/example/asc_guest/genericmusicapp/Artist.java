package com.example.asc_guest.genericmusicapp;

import java.util.ArrayList;

public class Artist{
    static private ArrayList<Artist> all = new ArrayList<Artist>();

    private String name;
    private ArrayList<Song> songs = new ArrayList<Song>();

    private Artist (String name){
        this.name = name;
        Artist.all.add(this);
    }

    public String getName(){
        return name;
    }

    public static ArrayList<Artist> getAll() {
        return all;
    }

    public static Artist create(String name){
        int index = Artist.findByName(name);
        if(index > 0) {
            return all.get(index);
        }
        return new Artist(name);
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

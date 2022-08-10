package com.example.movies_rajbeer_sokhi.singleton;

import com.example.movies_rajbeer_sokhi.models.Movies;

import java.util.ArrayList;

public class MoviesSingleton {

    private static MoviesSingleton instance = null;
    public static MoviesSingleton getInstance(){
        if(instance == null){
            instance = new MoviesSingleton();
        }
        return instance;
    }

    private ArrayList<Movies> movieList = new ArrayList<>();

    public ArrayList<Movies> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movies> movieList) {
        this.movieList = movieList;
    }
}

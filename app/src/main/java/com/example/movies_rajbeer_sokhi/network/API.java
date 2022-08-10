package com.example.movies_rajbeer_sokhi.network;

import com.example.movies_rajbeer_sokhi.models.MovieResponsObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    @GET("now_playing?api_key=8f89a0899b927135c722c5e3d04fb089&lang%20uage=en-US&page=1&region=CA")
    public Call<MovieResponsObject> getAllMovies();


}

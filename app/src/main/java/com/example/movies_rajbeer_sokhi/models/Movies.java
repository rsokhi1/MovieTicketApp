package com.example.movies_rajbeer_sokhi.models;

import com.google.gson.annotations.SerializedName;

public class Movies {
    @SerializedName("original_title")
    private String title;
    private String release_date;
    private String overview;
    private String poster_path;

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    @Override
    public String toString() {
        return "Moive{" +
                "title='" + title + '\'' +
                ", release_date='" + release_date + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                '}';
    }
}

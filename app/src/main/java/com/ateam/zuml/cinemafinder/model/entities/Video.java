package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

// Get the videos that have been added to a movie.
public class Video {
    @SerializedName("id")
    private int movieId;
    @SerializedName("iso_639_1")
    private String languageId;
    @SerializedName("iso_3166_1")
    private String countryId;
    private String key;     //video id for hosting site
    private String name;
    private String site;    //hosting site as tag YoutTube, Vimeo, etc..
    private int size;       //video quality
    private String type;    //Allowed Values: Trailer, Teaser, Clip, Featurette

    public int getMovieId() {
        return movieId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}

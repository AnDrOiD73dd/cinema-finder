package com.ateam.zuml.cinemafinder.service.model.movie.video;

import com.google.gson.annotations.SerializedName;

// Get the videos that have been added to a movie.
public final class Video {
    @SerializedName("id") private final int movieId;
    @SerializedName("iso_639_1") private final String languageId;
    @SerializedName("iso_3166_1") private final String countryId;
    private final String key;     //video id for hosting site
    private final String name;
    private final String site;    //hosting site as tag YouTube, Vimeo, etc..
    private final int size;       //video quality
    private final String type;    //Allowed Values: Trailer, Teaser, Clip, Featurette

    public Video(final int movieId, final String languageId, final String countryId, final String key,
                 final String name, final String site, final int size, final String type) {
        this.movieId = movieId;
        this.languageId = languageId;
        this.countryId = countryId;
        this.key = key;
        this.name = name;
        this.site = site;
        this.size = size;
        this.type = type;
    }

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

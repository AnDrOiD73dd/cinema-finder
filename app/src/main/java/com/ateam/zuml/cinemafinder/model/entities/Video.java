package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("id")
    int movieId;
    String iso639;
    @SerializedName("iso_3166_1")
    String countryId;
    String key; //video id for hosting site
    String name;
    String site;
    int size;   //acpect ratio for video
    String type;    //Allowed Values: Trailer, Teaser, Clip, Featurette
}

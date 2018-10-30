package com.ateam.zuml.cinemafinder.model.entities;

import com.google.gson.annotations.SerializedName;

public class MovieCredits {
    @SerializedName("id")
    int movieId;
    Cast[] cast;
    Crew[] crew;
}

package com.ateam.zuml.cinemafinder.model.entities;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class MovieCardResult {
    @SerializedName("id")
    int movieId;
    @Nullable String backdropPath;  //кадр из  фильма
    boolean video;
    int[] genreIds;
    boolean adult;
}

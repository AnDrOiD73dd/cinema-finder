package com.ateam.zuml.cinemafinder.database.room.model.environmet;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.ListConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "variables")
@TypeConverters(ListConverter.class)
public class ConfigurationEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("base_url")
    @NonNull final private String baseUrl;

    @SerializedName("secure_base_url")
    @NonNull final private String secureBaseUrl;

    @SerializedName("backdrop_sizes")
    @NonNull final private List<String> backdropSizes;

    @SerializedName("logo_sizes")
    @NonNull final private List<String> logoSizes;

    @SerializedName("poster_sizes")
    @NonNull final private List<String> posterSizes;

    @SerializedName("profile_sizes")
    @NonNull final private List<String> profileSizes;

    @SerializedName("still_sizes")
    @NonNull final private List<String> stillSizes;

    public ConfigurationEntity(int id, @NonNull String baseUrl, @NonNull String secureBaseUrl,
                               @NonNull List<String> backdropSizes, @NonNull List<String> logoSizes,
                               @NonNull List<String> posterSizes, @NonNull List<String> profileSizes,
                               @NonNull List<String> stillSizes) {
        this.baseUrl = baseUrl;
        this.secureBaseUrl = secureBaseUrl;
        this.backdropSizes = backdropSizes;
        this.logoSizes = logoSizes;
        this.posterSizes = posterSizes;
        this.profileSizes = profileSizes;
        this.stillSizes = stillSizes;
    }

    @NonNull
    public String getBaseUrl() {
        return baseUrl;
    }

    @NonNull
    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    @NonNull
    public List<String> getBackdropSizes() {
        return backdropSizes;
    }

    @NonNull
    public List<String> getLogoSizes() {
        return logoSizes;
    }

    @NonNull
    public List<String> getPosterSizes() {
        return posterSizes;
    }

    @NonNull
    public List<String> getProfileSizes() {
        return profileSizes;
    }

    @NonNull
    public List<String> getStillSizes() {
        return stillSizes;
    }

    public int getId() {
        return id;
    }
}

package com.ateam.zuml.cinemafinder.database.room.model.environmet;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.VideoTypeConverter;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.ateam.zuml.cinemafinder.database.room.model.enums.VideoType;

@Entity(tableName = "video",
        indices = {@Index(value = {"movie_id", "country_id", "language_id"})},
        foreignKeys = @ForeignKey(entity = MovieEntity.class,
                parentColumns = "id",
                childColumns = "movie_id",
                onDelete = ForeignKey.CASCADE))
public final class VideoEntity {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "movie_id")
    private final int movieId;

    @ColumnInfo(name = "language_id")
    @NonNull
    private final String languageId;

    @ColumnInfo(name = "country_id")
    @NonNull
    private final String countryId;

    @ColumnInfo(name = "video_key")
    @NonNull
    private final String videoKey;

    @NonNull
    private final String name;

    @ColumnInfo(name = "site_name")
    @NonNull
    private final String siteName;

    @NonNull
    @TypeConverters(VideoTypeConverter.class)
    private final VideoType type;

    public VideoEntity(int movieId, @NonNull String languageId, @NonNull String countryId,
                       @NonNull String videoKey, @NonNull String name, @NonNull String siteName,
                       @NonNull VideoType type) {
        this.movieId = movieId;
        this.languageId = languageId;
        this.countryId = countryId;
        this.videoKey = videoKey;
        this.name = name;
        this.siteName = siteName;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    @NonNull
    public String getLanguageId() {
        return languageId;
    }

    @NonNull
    public String getCountryId() {
        return countryId;
    }

    @NonNull
    public String getVideoKey() {
        return videoKey;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getSiteName() {
        return siteName;
    }

    @NonNull
    public VideoType getType() {
        return type;
    }
}

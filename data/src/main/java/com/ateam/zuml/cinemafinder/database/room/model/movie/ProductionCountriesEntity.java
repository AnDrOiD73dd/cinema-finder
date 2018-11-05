package com.ateam.zuml.cinemafinder.database.room.model.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.ateam.zuml.cinemafinder.database.room.model.environmet.CountryEntity;

@Entity(tableName = "production_countries",
        indices = @Index(value = {"movie_id"}),
        primaryKeys = {"country_id", "movie_id"},
        foreignKeys = {@ForeignKey(entity = MovieEntity.class,
                parentColumns = "id",
                childColumns = "movie_id",
                onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = CountryEntity.class,
                        parentColumns = "id",
                        childColumns = "country_id",
                        onDelete = ForeignKey.CASCADE)})
public final class ProductionCountriesEntity {
    @ColumnInfo(name = "country_id")
    private final int countryId;

    @ColumnInfo(name = "movie_id")
    private final int movieId;

    public ProductionCountriesEntity(int countryId, int movieId) {
        this.countryId = countryId;
        this.movieId = movieId;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getMovieId() {
        return movieId;
    }
}

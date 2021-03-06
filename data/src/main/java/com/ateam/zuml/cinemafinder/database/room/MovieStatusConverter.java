package com.ateam.zuml.cinemafinder.database.room;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.model.enums.MovieStatus;

public final class MovieStatusConverter {
    @TypeConverter
    public MovieStatus convertStoredValueToMovieStatus(String value) {
        for (MovieStatus entity : MovieStatus.values()) {
            if (entity.name().equals(value)) {
                return entity;
            }
        }
        return MovieStatus.NONE;
    }

    @TypeConverter
    public String convertMovieStatusToStoredValue(@NonNull MovieStatus status) {
        return status.name();
    }

}

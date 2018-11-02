package com.ateam.zuml.cinemafinder.database.room.converters;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.enums.MovieStatus;

public class MovieStatusConverter {
    @TypeConverter
    public
    MovieStatus convertStoredValueToMovieStatus(int value) {
        for (MovieStatus lc: MovieStatus.values()) {
            if (lc.ordinal() == value) {
                return lc;
            }
        }
        return null;
    }

    @TypeConverter
    public int convertMovieStatusToStoredValue(@NonNull MovieStatus status) {
        return status.ordinal();
    }

}

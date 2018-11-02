package com.ateam.zuml.cinemafinder.database.room.converters;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.enums.AnnotatedMovieStatus;

public class MovieStatusConverter {
    @TypeConverter
    public AnnotatedMovieStatus convertStoredValueToMovieStatus(String value) {
        for (AnnotatedMovieStatus lc : AnnotatedMovieStatus.values()) {
            if (lc.name().equals(value)) {
                return lc;
            }
        }
        return null;
    }

    @TypeConverter
    public int convertMovieStatusToStoredValue(@NonNull AnnotatedMovieStatus status) {
        return status.ordinal();
    }

}

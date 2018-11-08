package com.ateam.zuml.cinemafinder.database.room;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.model.enums.MovieCollectionType;

public final class MovieCollectionConverter {
    @TypeConverter
    public MovieCollectionType convertStoredValueToCollectionType(String value) {
        for (MovieCollectionType entity : MovieCollectionType.values()) {
            if (entity.name().equals(value)) {
                return entity;
            }
        }
        return MovieCollectionType.NO_COLLECTION;
    }

    @TypeConverter
    public String convertCollectionTypeToStoredValue(@NonNull MovieCollectionType type) {
        return type.name();
    }

}

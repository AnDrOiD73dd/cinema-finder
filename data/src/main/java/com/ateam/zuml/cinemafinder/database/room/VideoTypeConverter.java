package com.ateam.zuml.cinemafinder.database.room;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.enums.VideoType;

public final class VideoTypeConverter {
    @TypeConverter
    public VideoType convertStoredValueToMovieStatus(String value) {
        for (VideoType entity : VideoType.values()) {
            if (entity.name().equals(value)) {
                return entity;
            }
        }
        return null;
    }

    @TypeConverter
    public String convertMovieStatusToStoredValue(@NonNull VideoType status) {
        return status.name();
    }

}

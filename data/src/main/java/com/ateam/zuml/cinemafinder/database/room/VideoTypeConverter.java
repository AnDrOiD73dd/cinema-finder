package com.ateam.zuml.cinemafinder.database.room;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.database.room.model.enums.VideoType;

public final class VideoTypeConverter {
    @TypeConverter
    public VideoType convertStoredValueToVideoType(String value) {
        for (VideoType entity : VideoType.values()) {
            if (entity.name().equals(value)) {
                return entity;
            }
        }
        return null;
    }

    @TypeConverter
    public String convertVideoTypeToStoredValue(@NonNull VideoType type) {
        return type.name();
    }

}

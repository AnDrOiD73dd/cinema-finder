package com.ateam.zuml.cinemafinder.database.room;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import java.util.Date;

public final class DateConverters {
    @TypeConverter
    public Date convertStoredValueToDate(Long value) {
        return new Date(value);
    }

    @TypeConverter
    public Long convertDateToStoredValue(@NonNull Date date) {
        return date.getTime();
    }
}

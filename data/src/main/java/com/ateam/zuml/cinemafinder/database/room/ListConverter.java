package com.ateam.zuml.cinemafinder.database.room;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ListConverter {

    private final Gson gson = new Gson();

    @TypeConverter
    public List<String> convertStoredValueToList(String value) {

        if (value == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<String>>() {}.getType();

        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public String convertListToStoredValue(@NonNull List<String> someList) {
        return gson.toJson(someList);
    }
}

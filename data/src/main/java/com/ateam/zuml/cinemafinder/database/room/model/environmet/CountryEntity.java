package com.ateam.zuml.cinemafinder.database.room.model.environmet;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "countries")
public final class CountryEntity {
    @PrimaryKey
    private final int id;

    @NonNull private final String name;


    public CountryEntity(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }
}

package com.ateam.zuml.cinemafinder.database.room.model.environmet;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "genres")
public final class GenreEntity {
    private final int id;
    @NonNull private final String name;


    public GenreEntity(int id, @NonNull String name) {
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

package com.ateam.zuml.cinemafinder.database.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.ateam.zuml.cinemafinder.database.room.model.environmet.FavoriteEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FavoriteEntity entity);

    @Delete
    void delete(FavoriteEntity entity);

    @Query("SELECT * FROM favorites")
    Single<List<FavoriteEntity>> getAll();
}

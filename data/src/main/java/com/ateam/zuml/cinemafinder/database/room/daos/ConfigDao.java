package com.ateam.zuml.cinemafinder.database.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ateam.zuml.cinemafinder.database.room.model.environmet.ConfigurationEntity;

import io.reactivex.Single;


@Dao
public interface ConfigDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ConfigurationEntity entity);

    @Update
    void update(ConfigurationEntity entity);

    @Query("SELECT * FROM variables")
    Single<ConfigurationEntity> getConfig();
}

package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.mapper.CharacteristicsMapper;
import com.ateam.zuml.cinemafinder.mapper.CharacteristicsMapperImpl;
import com.ateam.zuml.cinemafinder.mapper.MovieMapper;
import com.ateam.zuml.cinemafinder.mapper.MovieMapperImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface MapperModule {

    @Singleton
    @Binds
    MovieMapper provideMovieMapper(final MovieMapperImpl mapper);

    @Singleton
    @Binds
    CharacteristicsMapper provideCharacteristicsMapper(final CharacteristicsMapperImpl mapper);
}

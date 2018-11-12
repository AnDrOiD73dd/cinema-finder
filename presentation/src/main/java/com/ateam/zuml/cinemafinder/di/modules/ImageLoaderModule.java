package com.ateam.zuml.cinemafinder.di.modules;

import com.ateam.zuml.cinemafinder.util.ImageLoader;
import com.ateam.zuml.cinemafinder.util.ImageLoaderPicasso;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface ImageLoaderModule {

    @Singleton
    @Binds
    ImageLoader provideImageLoader(final ImageLoaderPicasso loader);
}

package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.image.ImageLoader;
import com.ateam.zuml.cinemafinder.util.image.ImageLoaderPicasso;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface ImageLoaderModule {

    @Singleton
    @Binds
    ImageLoader provideImageLoader(final ImageLoaderPicasso loader);
}

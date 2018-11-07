package com.ateam.zuml.cinemafinder.di.application.modules;

import android.widget.ImageView;

import com.ateam.zuml.cinemafinder.util.image.ImageLoader;
import com.ateam.zuml.cinemafinder.util.image.ImageLoaderPicasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageLoaderModule {

    @Singleton
    @Provides
    ImageLoader<ImageView> provideImageLoader() {
        return new ImageLoaderPicasso();
    }
}

package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.StringUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class UtilsModule {

    @Singleton
    @Provides
    StringUtil provideStringUtil() {
        return new StringUtil();
    }
}

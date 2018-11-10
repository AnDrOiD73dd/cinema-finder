package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.Logger;
import com.ateam.zuml.cinemafinder.util.StringUtilImpl;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract interface UtilsModule {

    @Singleton
    @Binds
    abstract StringUtils provideStringUtil(final StringUtilImpl stringUtil);

    @Singleton
    @Provides
    static Logger provideLogger() {
        return new Logger("ZUML", true);
    }
}

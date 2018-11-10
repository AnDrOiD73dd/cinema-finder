package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.Constants;
import com.ateam.zuml.cinemafinder.util.Logger;
import com.ateam.zuml.cinemafinder.util.StringUtilImpl;
import com.ateam.zuml.cinemafinder.util.StringUtils;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class UtilsModule {

    @Singleton
    @Binds
    abstract StringUtils provideStringUtil(final StringUtilImpl stringUtil);

    @Singleton
    @Provides
    static Logger provideLogger(@Named(Constants.APP_TAG) String appTag,
                                @Named("PrintFileName") boolean isPrintFileName) {
        return new Logger(appTag, isPrintFileName);
    }

    @Named(Constants.APP_TAG)
    @Provides
    static String provideAppTag() {
        return Constants.APP_TAG;
    }

    @Named("PrintFileName")
    @Provides
    static boolean provideIsPrintFileName() {
        return true;
    }
}

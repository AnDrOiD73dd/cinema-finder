package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.navigation.CiceroneHolder;
import com.ateam.zuml.cinemafinder.util.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public final class NavigationModule {

    @Named(Constants.MAIN_CONTAINER)
    @Provides
    String getMainContainer() {
        return "main_container";
    }

    @Named(Constants.CHILD_CONTAINER)
    @Provides
    String getHomeContainer() {
        return "child_container";
    }

    @Singleton
    @Provides
    CiceroneHolder provideNavigationHolder() {
        return new CiceroneHolder();
    }

    @Named(Constants.MAIN_CONTAINER)
    @Singleton
    @Provides
    Router provideMainRouter(CiceroneHolder ciceroneHolder,
                             @Named(Constants.MAIN_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getRouter();
    }

    @Named(Constants.MAIN_CONTAINER)
    @Singleton
    @Provides
    NavigatorHolder provideMainNavigatorHolder(CiceroneHolder ciceroneHolder,
                                               @Named(Constants.MAIN_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getNavigatorHolder();
    }

    @Named(Constants.CHILD_CONTAINER)
    @Singleton
    @Provides
    Router provideChildRouter(CiceroneHolder ciceroneHolder,
                              @Named(Constants.CHILD_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getRouter();
    }

    @Named(Constants.CHILD_CONTAINER)
    @Singleton
    @Provides
    NavigatorHolder provideChildNavigatorHolder(CiceroneHolder ciceroneHolder,
                                                @Named(Constants.CHILD_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getNavigatorHolder();
    }
}

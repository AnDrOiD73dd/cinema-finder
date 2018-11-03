package com.ateam.zuml.cinemafinder.di.application.modules;

import com.ateam.zuml.cinemafinder.util.CiceroneHolder;
import com.ateam.zuml.cinemafinder.util.Const;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {

    @Named(Const.MAIN_CONTAINER)
    @Provides
    String getMainContainer() {
        return "main_container";
    }

    @Named(Const.CHILD_CONTAINER)
    @Provides
    String getHomeContainer() {
        return "child_container";
    }

    @Singleton
    @Provides
    CiceroneHolder provideNavigationHolder() {
        return new CiceroneHolder();
    }

    @Named(Const.MAIN_CONTAINER)
    @Singleton
    @Provides
    Router provideMainRouter(CiceroneHolder ciceroneHolder,
                             @Named(Const.MAIN_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getRouter();
    }

    @Named(Const.MAIN_CONTAINER)
    @Singleton
    @Provides
    NavigatorHolder provideMainNavigatorHolder(CiceroneHolder ciceroneHolder,
                                               @Named(Const.MAIN_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getNavigatorHolder();
    }

    @Named(Const.CHILD_CONTAINER)
    @Singleton
    @Provides
    Router provideChildRouter(CiceroneHolder ciceroneHolder,
                              @Named(Const.CHILD_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getRouter();
    }

    @Named(Const.CHILD_CONTAINER)
    @Singleton
    @Provides
    NavigatorHolder provideChildNavigatorHolder(CiceroneHolder ciceroneHolder,
                                                @Named(Const.CHILD_CONTAINER) String containerName) {
        return ciceroneHolder.getCicerone(containerName).getNavigatorHolder();
    }
}

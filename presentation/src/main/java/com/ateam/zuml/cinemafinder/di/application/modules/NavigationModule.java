package com.ateam.zuml.cinemafinder.di.application.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {

    private Cicerone<Router> cicerone;

    public NavigationModule() {
        this.cicerone = Cicerone.create();
    }

    @Singleton
    @Provides
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    @Singleton
    @Provides
    Router provideRouter() {
        return cicerone.getRouter();
    }
}

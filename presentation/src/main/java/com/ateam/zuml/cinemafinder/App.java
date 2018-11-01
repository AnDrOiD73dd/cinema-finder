package com.ateam.zuml.cinemafinder;

import android.app.Application;

import com.ateam.zuml.cinemafinder.di.application.ApplicationComponent;
import com.ateam.zuml.cinemafinder.di.application.DaggerApplicationComponent;

public final class App extends Application {

    private static App application;
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        application = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .with(getApplicationContext())
                .build();
    }

    public static App getApp() {
        return application;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}

package com.ateam.zuml.cinemafinder;

import android.app.Application;

import com.ateam.zuml.cinemafinder.di.application.AppComponent;
import com.ateam.zuml.cinemafinder.di.application.DaggerAppComponent;

public final class App extends Application {

    private static App app;

    private AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .with(getApplicationContext())
                .build();
    }

    public static App getApp() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

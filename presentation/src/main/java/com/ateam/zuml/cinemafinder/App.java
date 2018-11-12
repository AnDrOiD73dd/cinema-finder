package com.ateam.zuml.cinemafinder;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.ateam.zuml.cinemafinder.di.AppComponent;
import com.ateam.zuml.cinemafinder.di.DaggerAppComponent;

public final class App extends Application {

    private static App app;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
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

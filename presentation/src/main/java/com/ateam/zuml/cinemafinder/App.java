package com.ateam.zuml.cinemafinder;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.ateam.zuml.cinemafinder.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public final class App extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> injector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return injector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        DaggerAppComponent.builder()
                .with(getApplicationContext())
                .build()
                .inject(this);
    }
}

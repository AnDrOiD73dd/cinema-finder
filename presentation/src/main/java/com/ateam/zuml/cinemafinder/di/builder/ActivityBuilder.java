package com.ateam.zuml.cinemafinder.di.builder;

import com.ateam.zuml.cinemafinder.ui.AppActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {

    @ContributesAndroidInjector(modules = FragmentsProvider.class)
    AppActivity bindAppActivity();
}

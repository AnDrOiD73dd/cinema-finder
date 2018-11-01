package com.ateam.zuml.cinemafinder.di.application;

import android.content.Context;

import com.ateam.zuml.cinemafinder.di.application.modules.ServiceModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = ServiceModule.class)
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        ApplicationComponent build();

        @BindsInstance Builder with(final Context context);
    }
}

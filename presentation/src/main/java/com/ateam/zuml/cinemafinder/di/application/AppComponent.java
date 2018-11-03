package com.ateam.zuml.cinemafinder.di.application;

import android.content.Context;

import com.ateam.zuml.cinemafinder.di.application.modules.NavigationModule;
import com.ateam.zuml.cinemafinder.di.application.modules.ServiceModule;
import com.ateam.zuml.cinemafinder.presentation.presenter.HomePresenter;
import com.ateam.zuml.cinemafinder.ui.HomeFragment;
import com.ateam.zuml.cinemafinder.ui.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class, NavigationModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance Builder with(final Context context);
    }

    void inject(MainActivity activity);

    void inject(HomeFragment fragment);

    void inject(HomePresenter presenter);
}

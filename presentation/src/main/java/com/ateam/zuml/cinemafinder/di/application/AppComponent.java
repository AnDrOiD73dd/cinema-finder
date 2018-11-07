package com.ateam.zuml.cinemafinder.di.application;

import android.content.Context;

import com.ateam.zuml.cinemafinder.di.application.modules.DataModule;
import com.ateam.zuml.cinemafinder.di.application.modules.MapperModule;
import com.ateam.zuml.cinemafinder.di.application.modules.NavigationModule;
import com.ateam.zuml.cinemafinder.di.application.modules.ServiceModule;
import com.ateam.zuml.cinemafinder.di.application.modules.UtilsModule;
import com.ateam.zuml.cinemafinder.presentation.presenter.DetailMoviePresenter;
import com.ateam.zuml.cinemafinder.presentation.presenter.FavoritesPresenter;
import com.ateam.zuml.cinemafinder.presentation.presenter.HomePresenter;
import com.ateam.zuml.cinemafinder.presentation.presenter.MainContainerPresenter;
import com.ateam.zuml.cinemafinder.presentation.presenter.RatingsPresenter;
import com.ateam.zuml.cinemafinder.presentation.presenter.SearchResponsePresenter;
import com.ateam.zuml.cinemafinder.ui.MainActivity;
import com.ateam.zuml.cinemafinder.ui.MainContainerFragment;
import com.ateam.zuml.cinemafinder.ui.SettingsFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        DataModule.class,
        MapperModule.class,
        NavigationModule.class,
        ServiceModule.class,
        UtilsModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        AppComponent build();
        @BindsInstance
        Builder with(final Context context);

    }
    void inject(MainActivity activity);

    void inject(MainContainerFragment fragment);

    void inject(MainContainerPresenter presenter);

    void inject(SettingsFragment fragment);

    void inject(HomePresenter presenter);

    void inject(FavoritesPresenter presenter);

    void inject(RatingsPresenter presenter);

    void inject(SearchResponsePresenter presenter);

    void inject(DetailMoviePresenter presenter);
}

package com.ateam.zuml.cinemafinder.di.application;

import android.content.Context;
import com.ateam.zuml.cinemafinder.di.application.modules.*;
import com.ateam.zuml.cinemafinder.ui.AppActivity;
import com.ateam.zuml.cinemafinder.ui.screens.details.DetailMovieFragment;
import com.ateam.zuml.cinemafinder.ui.screens.details.DetailMoviePresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.MainContainerFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.MainContainerPresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.favorites.FavoritesPresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.home.HomeFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.home.HomePresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.ratings.RatingsPresenter;
import com.ateam.zuml.cinemafinder.ui.screens.search.SearchResponseFragment;
import com.ateam.zuml.cinemafinder.ui.screens.search.SearchResponsePresenter;
import com.ateam.zuml.cinemafinder.ui.screens.settings.SettingsFragment;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        DataModule.class,
        MapperModule.class,
        NavigationModule.class,
        ServiceModule.class,
        ImageLoaderModule.class,
        UtilsModule.class,
        SchedulersModule.class,
        PreferencesModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder with(final Context context);

    }

    void inject(AppActivity activity);

    void inject(MainContainerFragment fragment);

    void inject(MainContainerPresenter presenter);

    void inject(SettingsFragment fragment);

    void inject(HomeFragment fragment);

    void inject(HomePresenter presenter);

    void inject(FavoritesPresenter presenter);

    void inject(RatingsPresenter presenter);

    void inject(SearchResponseFragment fragment);

    void inject(SearchResponsePresenter presenter);

    void inject(DetailMovieFragment fragment);

    void inject(DetailMoviePresenter presenter);
}

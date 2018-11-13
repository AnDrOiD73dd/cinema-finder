package com.ateam.zuml.cinemafinder.di;

import android.content.Context;

import com.ateam.zuml.cinemafinder.di.modules.DataModule;
import com.ateam.zuml.cinemafinder.di.modules.DatabaseModule;
import com.ateam.zuml.cinemafinder.di.modules.ImageLoaderModule;
import com.ateam.zuml.cinemafinder.di.modules.MapperModule;
import com.ateam.zuml.cinemafinder.di.modules.NavigationModule;
import com.ateam.zuml.cinemafinder.di.modules.SchedulersModule;
import com.ateam.zuml.cinemafinder.di.modules.ServiceModule;
import com.ateam.zuml.cinemafinder.di.modules.UtilsModule;
import com.ateam.zuml.cinemafinder.ui.AppActivity;
import com.ateam.zuml.cinemafinder.ui.screens.details.DetailMovieFragment;
import com.ateam.zuml.cinemafinder.ui.screens.details.DetailMoviePresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.MainContainerFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.MainContainerPresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.favorites.FavoritesFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.favorites.FavoritesPresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.home.HomeFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.home.HomePresenter;
import com.ateam.zuml.cinemafinder.ui.screens.main.ratings.RatingsFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.ratings.RatingsPresenter;
import com.ateam.zuml.cinemafinder.ui.screens.search.SearchResponseFragment;
import com.ateam.zuml.cinemafinder.ui.screens.search.SearchResponsePresenter;
import com.ateam.zuml.cinemafinder.ui.screens.settings.SettingsFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        DataModule.class,
        MapperModule.class,
        NavigationModule.class,
        ServiceModule.class,
        ImageLoaderModule.class,
        UtilsModule.class,
        SchedulersModule.class,
        DatabaseModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder with(final Context context);
    }

    void inject(AppActivity activity);

    void inject(DetailMovieFragment fragment);

    void inject(DetailMoviePresenter presenter);

    void inject(FavoritesFragment fragment);

    void inject(FavoritesPresenter presenter);

    void inject(HomeFragment fragment);

    void inject(HomePresenter presenter);

    void inject(MainContainerFragment fragment);

    void inject(MainContainerPresenter presenter);

    void inject(RatingsFragment fragment);

    void inject(RatingsPresenter presenter);

    void inject(SearchResponseFragment fragment);

    void inject(SearchResponsePresenter presenter);

    void inject(SettingsFragment fragment);
}

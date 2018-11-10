package com.ateam.zuml.cinemafinder.di.application;

import android.content.Context;
import com.ateam.zuml.cinemafinder.di.application.modules.*;
import com.ateam.zuml.cinemafinder.presentation.presenter.*;
import com.ateam.zuml.cinemafinder.ui.*;
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
        SchedulersModule.class})
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

    void inject(SearchResponseFragment fragment);

    void inject(SearchResponsePresenter presenter);

    void inject(DetailMovieFragment fragment);

    void inject(DetailMoviePresenter presenter);

    void inject(RowFragment fragment);

    void inject(RowPresenter presenter);
}

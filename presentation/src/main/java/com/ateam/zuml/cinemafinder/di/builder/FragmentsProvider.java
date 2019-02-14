package com.ateam.zuml.cinemafinder.di.builder;

import com.ateam.zuml.cinemafinder.ui.screens.details.DetailMovieFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.MainContainerFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.favorites.FavoritesFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.home.HomeFragment;
import com.ateam.zuml.cinemafinder.ui.screens.main.ratings.RatingsFragment;
import com.ateam.zuml.cinemafinder.ui.screens.search.SearchResponseFragment;
import com.ateam.zuml.cinemafinder.ui.screens.settings.SettingsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentsProvider {

    @ContributesAndroidInjector
    DetailMovieFragment provideDetailMovieFragment();

    @ContributesAndroidInjector
    FavoritesFragment provideFavoritesFragment();

    @ContributesAndroidInjector
    HomeFragment provideHomeFragment();

    @ContributesAndroidInjector
    MainContainerFragment provideMainContainerFragment();

    @ContributesAndroidInjector
    RatingsFragment provideRatingsFragment();

    @ContributesAndroidInjector
    SearchResponseFragment provideSearchResponseFragment();

    @ContributesAndroidInjector
    SettingsFragment provideSettingsFragment();
}

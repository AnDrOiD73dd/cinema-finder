package com.ateam.zuml.cinemafinder.ui;

import android.support.v4.app.Fragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    //TODO 03.11.2018 В этом классе надо что-то подумать c переиспользование фрагментов
    public static final class HomeScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return MainContainerFragment.newInstance();
        }
    }

    public static final class TrendsScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return HomeFragment.newInstance();
        }
    }

    public static final class FavoritesScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return FavoritesFragment.newInstance();
        }
    }

    public static final class RatingsScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return RatingsFragment.newInstance();
        }
    }

    public static final class SettingsScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return SettingsFragment.newInstance();
        }
    }

    public static final class SearchResponseScreen extends SupportAppScreen {
        private final String query;

         SearchResponseScreen(String query) {
            this.query = query;
        }

        @Override
        public Fragment getFragment()   {
            return SearchResponseFragment.newInstance(query);
        }
    }

    public static final class DetailMovieScreen extends SupportAppScreen {
        private final String movieId;

        public DetailMovieScreen(String movieId) {
            this.movieId = movieId;
        }

        @Override
        public Fragment getFragment()   {
            return DetailMovieFragment.newInstance(movieId);
        }
    }
}

package com.ateam.zuml.cinemafinder.ui;

import android.support.v4.app.Fragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class HomeScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return HomeFragment.newInstance();
        }
    }

    public static final class TrendsScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment()   {
            return TrendsFragment.newInstance();
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
}

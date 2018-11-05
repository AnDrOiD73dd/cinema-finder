package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.util.Const;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class MainActivity extends AppCompatActivity implements WidgetTuning {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.search) SearchView search;

    @Named(Const.MAIN_CONTAINER) @Inject NavigatorHolder navigatorHolder;
    @Named(Const.MAIN_CONTAINER) @Inject Router router;

    private Navigator navigator = new SupportAppNavigator(this, R.id.main_container) {
        @Override
        public void applyCommands(Command[] commands) {
            super.applyCommands(commands);
            getSupportFragmentManager().executePendingTransactions();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getApp().getAppComponent().inject(this);
        super.onCreate(savedInstanceState);

        init();

        if (savedInstanceState == null) {
            router.navigateTo(new Screens.HomeScreen());
        }
    }

    private void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                router.navigateTo(new Screens.SearchResponseScreen(s));
                search.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                search.onActionViewCollapsed();
                router.exit();
                return true;
            case R.id.action_settings:
                router.navigateTo(new Screens.SettingsScreen());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setupToolbar(String title, boolean visible) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(visible);
            actionBar.setElevation(0);
        }
    }

    @Override
    public void setSearchVisibility(boolean visible)    {
        if(visible)    {
            search.setVisibility(View.VISIBLE);
        }else {
            search.setVisibility(View.GONE);
        }
    }

    @Override
    public void closeSearch()   {
        search.onActionViewCollapsed();
    }

    @Override
    public void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    public void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}

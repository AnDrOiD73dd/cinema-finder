package com.ateam.zuml.cinemafinder.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.util.Constants;

import java.util.List;

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
    @BindView(R.id.search) SearchView searchView;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    NavigatorHolder navigatorHolder;

    @Named(Constants.MAIN_CONTAINER)
    @Inject
    Router router;

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
            router.navigateTo(new Screens.MainContainerScreen());
        }
    }

    private void init() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.gray500));
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                router.navigateTo(new Screens.SearchResponseScreen(s));
                searchView.clearFocus();
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
                searchView.onActionViewCollapsed();
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
        }
    }

    @Override
    public void setSearchVisibility(boolean visible)    {
        if(visible)    {
            searchView.setVisibility(View.VISIBLE);
        }else {
            searchView.setVisibility(View.GONE);
        }
    }

    @Override
    public void closeSearch()   {
        searchView.onActionViewCollapsed();
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

    @Override
    public void onBackPressed() {
        Fragment fragment = null;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment f : fragments) {
            if (f.isVisible()) {
                fragment = f;
                break;
            }
        }
        if (fragment instanceof BackButtonListener && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            router.exit();
        }
    }
}

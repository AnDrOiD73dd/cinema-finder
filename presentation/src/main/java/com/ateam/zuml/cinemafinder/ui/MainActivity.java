package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ateam.zuml.cinemafinder.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WidgetTuning {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_container, new TrendsFragment())
                    .commit();
        }
    }

    private void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.action_trends:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, new TrendsFragment())
                            .commit();
                    return true;
                case R.id.action_favorites:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, new FavoritesFragment())
                            .commit();
                    return true;
                case R.id.action_ratings:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, new RatingsFragment())
                            .commit();
                    return true;
                default:
                    return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                return true;
            case R.id.action_settings:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new SettingsFragment())
                        .addToBackStack(null)
                        .commit();
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
    public void setBottomNavigationVisibility(boolean visible) {
        if (visible) {
            bottomNavigationView.setVisibility(View.VISIBLE);
        } else {
            bottomNavigationView.setVisibility(View.GONE);
        }
    }
}

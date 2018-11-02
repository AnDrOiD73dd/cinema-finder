package com.ateam.zuml.cinemafinder.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ateam.zuml.cinemafinder.R;

public class MainActivity extends AppCompatActivity implements WidgetTuning, HomeFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            setFragment(HomeFragment.newInstance(), HomeFragment.TAG);
        }
    }

    private void setFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    @Override
    public void setupToolbar(Toolbar toolbar, String title, boolean visible) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(visible);
            actionBar.setElevation(0);
        }
    }

    @Override
    public void onOpenSettingsClick() {
        setFragment(SettingsFragment.newInstance(), SettingsFragment.TAG);
    }
}

package com.ateam.zuml.cinemafinder.ui;

import android.content.Context;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.ui.common.WidgetTuning;

import dagger.android.support.AndroidSupportInjection;

public class BaseFragment extends MvpAppCompatFragment {

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    protected void setupToolbar(int resId, boolean visibleHome) {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (AppActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(resId), visibleHome);
            widgetTuning.setSearchVisibility(true);
        }
    }
}

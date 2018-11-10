package com.ateam.zuml.cinemafinder.ui;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.ateam.zuml.cinemafinder.ui.common.WidgetTuning;

public class BaseFragment extends MvpAppCompatFragment {

    protected void setupToolbar(int resId, boolean visibleHome) {
        setHasOptionsMenu(true);
        WidgetTuning widgetTuning = (AppActivity) getActivity();
        if (widgetTuning != null) {
            widgetTuning.setupToolbar(getResources().getString(resId), visibleHome);
            widgetTuning.setSearchVisibility(true);
        }
    }
}

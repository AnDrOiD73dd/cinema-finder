package com.ateam.zuml.cinemafinder.util;

import com.ateam.zuml.cinemafinder.R;

public enum CollectionsRow {
    UPCOMING(R.string.category_title_upcoming),
    NOW_PLAYING(R.string.category_title_now_playing),
    NONE(R.string.category_title_none);

    private int title;

    CollectionsRow(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }
}
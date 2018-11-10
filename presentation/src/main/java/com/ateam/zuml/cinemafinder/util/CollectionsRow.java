package com.ateam.zuml.cinemafinder.util;

import com.ateam.zuml.cinemafinder.R;

public enum CollectionsRow {
    POPULAR(R.string.category_title_popular),
    UPCOMING(R.string.category_title_upcoming),
    NOW_PLAYING(R.string.category_title_now_playing),
    LATEST(R.string.category_title_latest),
    NONE(R.string.category_title_none);

    private int title;

    CollectionsRow(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }
}
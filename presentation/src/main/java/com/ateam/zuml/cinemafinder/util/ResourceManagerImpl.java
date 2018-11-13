package com.ateam.zuml.cinemafinder.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.ateam.zuml.cinemafinder.R;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ResourceManagerImpl implements ResourceManager {

    private Context context;

    @Inject
    ResourceManagerImpl(Context context) {
        this.context = context;
    }

    @NonNull
    private String getString(@StringRes int resId) {
        return context.getResources().getString(resId);
    }

    @Override
    public String getAddedInFavorites() {
        return getString(R.string.added_favorite_item);
    }

    @Override
    public String getErrorAddInFavorites() {
        return getString(R.string.error_add_favorite_item);
    }

    @Override
    public String getRemovedFromFavorites() {
        return getString(R.string.removed_favorite_item);
    }

    @Override
    public String getErrorRemoveFromFavorites() {
        return getString(R.string.error_remove_favorite_item);
    }
}

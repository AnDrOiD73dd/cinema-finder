package com.ateam.zuml.cinemafinder.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ateam.zuml.cinemafinder.R;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ResourceManagerImpl implements ResourceManager {

    private Context context;

    @Inject
    public ResourceManagerImpl(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public String getPackageName() {
        return context.getResources().getString(R.string.app_name);
    }
}

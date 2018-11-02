package com.ateam.zuml.cinemafinder.utils;

import android.content.Context;

import com.ateam.zuml.cinemafinder.enums.MovieStatus;

public final class SourceUtilImpl implements SourceUtil {
    final Context context;

    public SourceUtilImpl(final Context context) {
        this.context = context;
    }

    @Override
    public String getStatus(final MovieStatus status) {
        return context.getString(status.getDescriptionId());
    }
}

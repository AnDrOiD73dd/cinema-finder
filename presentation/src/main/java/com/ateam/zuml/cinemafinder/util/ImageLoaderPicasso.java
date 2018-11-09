package com.ateam.zuml.cinemafinder.util;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ateam.zuml.cinemafinder.R;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ImageLoaderPicasso implements ImageLoader {

    @Inject
    ImageLoaderPicasso() {
    }

    @Override
    public void loadInto(@Nullable String url, ImageView container) {
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_broken_image)
                .into(container);
    }
}
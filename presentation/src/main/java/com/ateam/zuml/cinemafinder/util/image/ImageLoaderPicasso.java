package com.ateam.zuml.cinemafinder.util.image;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoaderPicasso implements ImageLoader<ImageView> {

    @Override
    public void loadInto(@Nullable String url, ImageView container) {
        Picasso.get().load(url).into(container);
    }
}
package com.ateam.zuml.cinemafinder.util.image;

import android.support.annotation.Nullable;
import android.widget.ImageView;

public interface ImageLoader {

    void loadInto(@Nullable String url, ImageView container);
}

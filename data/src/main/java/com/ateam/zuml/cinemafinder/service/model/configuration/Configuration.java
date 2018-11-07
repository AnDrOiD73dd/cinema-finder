package com.ateam.zuml.cinemafinder.service.model.configuration;

import com.ateam.zuml.cinemafinder.service.api.ApiService;

/**
 * Result for {@link ApiService#getConfiguration()}
 */
public final class Configuration {

    private final Images images;
    private final String[] changeKeys;

    public Configuration(final Images images, final String[] changeKeys) {
        this.images = images;
        this.changeKeys = changeKeys;
    }

    public Images getImages() {
        return images;
    }

    public String[] getChangeKeys() {
        return changeKeys;
    }
}

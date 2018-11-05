package com.ateam.zuml.cinemafinder.service.model.configuration;

public final class Configuration {

    private final Images images;
    private final String[] changeKeys;

    public Configuration(Images images, String[] changeKeys) {
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

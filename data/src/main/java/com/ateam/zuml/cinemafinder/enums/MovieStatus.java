package com.ateam.zuml.cinemafinder.enums;

import com.ateam.zuml.cinemafinder.R;

public enum MovieStatus {
    RUMORED(R.string.movie_type_rumored),
    PLANNED(R.string.movie_type_rumored),
    IN_PRODUCTION(R.string.movie_type_in_production),
    POST_PRODUCTION(R.string.movie_type_post_production),
    RELEASED(R.string.movie_type_released),
    CANCELED(R.string.movie_type_canceled);

    private int descriptionId;

    MovieStatus(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public String getDescription() {
        return App.context().getString(descriptionId);
    }

}

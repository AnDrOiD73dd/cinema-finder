package com.ateam.zuml.cinemafinder.service.model.common.video;

import com.google.gson.annotations.SerializedName;

/**
 * Part of {@link VideoSet}
 */
public final class Video {

    @SerializedName("iso_639_1") private final String languageId;
    @SerializedName("iso_3166_1") private final String countryId;
    private final int id;
    private final String key;
    private final String name;
    private final String site;
    private final int size;
    private final String type;

    public Video(final int id, final String languageId, final String countryId, final String key,
                 final String name, final String site, final int size, final String type) {
        this.id = id;
        this.languageId = languageId;
        this.countryId = countryId;
        this.key = key;
        this.name = name;
        this.site = site;
        this.size = size;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    /**
     * @return Allowed Values: 360, 480, 720, 1080
     */
    public int getSize() {
        return size;
    }

    /**
     * @return Allowed Values: Trailer, Teaser, Clip, Featurette
     */
    public String getType() {
        return type;
    }
}

package com.ateam.zuml.cinemafinder.service.model.configuration;

/**
 * Part of  {@link Configuration}
 */
public final class Images {

    private final String baseUrl;
    private final String secureBaseUrl;
    private final String[] backdropSizes;
    private final String[] logoSizes;
    private final String[] posterSizes;
    private final String[] profileSizes;
    private final String[] stillSizes;

    public Images(final String baseUrl, final String secureBaseUrl, final String[] backdropSizes,
                  final String[] logoSizes, final String[] posterSizes, final String[] profileSizes,
                  final String[] stillSizes) {
        this.baseUrl = baseUrl;
        this.secureBaseUrl = secureBaseUrl;
        this.backdropSizes = backdropSizes;
        this.logoSizes = logoSizes;
        this.posterSizes = posterSizes;
        this.profileSizes = profileSizes;
        this.stillSizes = stillSizes;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    public String[] getBackdropSizes() {
        return backdropSizes;
    }

    public String[] getLogoSizes() {
        return logoSizes;
    }

    public String[] getPosterSizes() {
        return posterSizes;
    }

    public String[] getProfileSizes() {
        return profileSizes;
    }

    public String[] getStillSizes() {
        return stillSizes;
    }
}

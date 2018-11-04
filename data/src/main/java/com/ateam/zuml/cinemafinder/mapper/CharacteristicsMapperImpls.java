package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class CharacteristicsMapperImpls implements CharacteristicsMapper {

    private static final String RU_LANGUAGE = "ru-RU";
    private static final String EN_LANGUAGE = "en-EN";
    private static final String RU_REGION = "ru";
    private static final String EN_REGION = "en";

    @Inject
    CharacteristicsMapperImpls() {
    }

    @Override
    public String mapLanguage(final Language language) {
        switch (language) {
            case RUSSIAN:
                return RU_LANGUAGE;
            case ENGLISH:
                return EN_LANGUAGE;
            default:
                throw new IllegalArgumentException("Illegal language type");
        }
    }

    @Override
    public String mapRegion(final Region region) {
        switch (region) {
            case RUSSIAN:
                return RU_REGION;
            case ENGLISH:
                return EN_REGION;
            default:
                throw new IllegalArgumentException("Illegal region type");
        }
    }
}

package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.service.api.ApiService;
import com.ateam.zuml.cinemafinder.service.model.configuration.Images;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class CharacteristicsMapperImpl implements CharacteristicsMapper {

    private static final String RU_LANGUAGE = "ru-RU";
    private static final String EN_LANGUAGE = "en-EN";
    private static final String RU_REGION = "ru";
    private static final String EN_REGION = "en";
    private final Images imageSizes;

    @Inject
    CharacteristicsMapperImpl(final ApiService apiService) {
        imageSizes = apiService.getConfiguration().blockingGet().getImages();// TODO: temporary solution. It will be replaced by cache
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

    @Override
    public String mapLogoSize(final LogoSize logoSize) {
        try {
            switch (logoSize) {
                case W_45:
                    return imageSizes.getLogoSizes()[0];
                case W_92:
                    return imageSizes.getLogoSizes()[1];
                case W_154:
                    return imageSizes.getLogoSizes()[2];
                case W_185:
                    return imageSizes.getLogoSizes()[3];
                case W_300:
                    return imageSizes.getLogoSizes()[4];
                case W_500:
                    return imageSizes.getLogoSizes()[5];
                case ORIGINAL:
                    return imageSizes.getLogoSizes()[6];
                default:
                    return imageSizes.getLogoSizes()[0];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return imageSizes.getLogoSizes()[0];
        }
    }
}

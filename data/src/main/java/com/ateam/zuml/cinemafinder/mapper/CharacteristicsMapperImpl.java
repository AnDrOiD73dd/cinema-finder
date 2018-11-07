package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.service.api.ApiService;
import com.ateam.zuml.cinemafinder.service.model.configuration.Images;
import com.ateam.zuml.cinemafinder.service.model.movie.Genre;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.schedulers.Schedulers;

@Singleton
public final class CharacteristicsMapperImpl implements CharacteristicsMapper {

    private static final String RU_LANGUAGE = "ru-RU";
    private static final String EN_LANGUAGE = "en-EN";
    private static final String RU_REGION = "ru";
    private static final String EN_REGION = "en";
    private final Images images;
    private final Genre[] ruGenres;
    private final Genre[] enGenres;

    @Inject
    CharacteristicsMapperImpl(final ApiService apiService) {
        images = apiService.getConfiguration()
                .subscribeOn(Schedulers.io()).blockingGet().getImages();// TODO: temporary solution. It will be replaced by cache
        ruGenres = apiService.getGenres(mapLanguage(Language.RUSSIAN))
                .subscribeOn(Schedulers.io()).blockingGet().getGenres();// TODO: temporary solution. It will be replaced by cache
        enGenres = apiService.getGenres(mapLanguage(Language.ENGLISH))
                .subscribeOn(Schedulers.io()).blockingGet().getGenres();// TODO: temporary solution. It will be replaced by cache
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
    public String mapLogoSizeToPath(final LogoSize logoSize, final String logoPath) {
        final String baseUrl = images.getSecureBaseUrl();
        String size;
        try {
            switch (logoSize) {
                case W_45:
                    size = images.getLogoSizes()[0];
                    break;
                case W_92:
                    size = images.getLogoSizes()[1];
                    break;
                case W_154:
                    size = images.getLogoSizes()[2];
                    break;
                case W_185:
                    size = images.getLogoSizes()[3];
                    break;
                case W_300:
                    size = images.getLogoSizes()[4];
                    break;
                case W_500:
                    size = images.getLogoSizes()[5];
                    break;
                case ORIGINAL:
                    size = images.getLogoSizes()[6];
                    break;
                default:
                    size = images.getLogoSizes()[0];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            size = images.getLogoSizes()[0];
        }
        return baseUrl + size + logoPath;
    }

    @Override
    public String[] mapGenres(final int[] genresIds, final Language language) {
        final Genre[] genres = language == Language.RUSSIAN ? ruGenres : enGenres;
        final String[] resultGenres = new String[genresIds.length];
        for (int i = 0; i < genresIds.length; i++) {
            for (final Genre genre : genres) {
                final int supposedGenre = genre.getId();
                if (genresIds[i] == supposedGenre) {
                    resultGenres[i] = genre.getName();
                    break;
                }
            }
        }
        return resultGenres;
    }

    @Override
    public String[] mapGenres(final Genre[] genres) {
        final String[] resultGenres = new String[genres.length];
        for (int i = 0; i < genres.length; i++) {
            resultGenres[i] = genres[i].getName();
        }
        return resultGenres;
    }
}

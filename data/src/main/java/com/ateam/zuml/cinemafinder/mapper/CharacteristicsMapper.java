package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.service.model.movie.Genre;

public interface CharacteristicsMapper {

    String mapLanguage(final Language language);

    String mapRegion(final Region region);

    String mapLogoSizeToPath(final LogoSize logoSize, final String logoPath);

    String[] mapGenres(final int[] genresIds, final Language language);

    String[] mapGenres(final Genre[] genres);
}

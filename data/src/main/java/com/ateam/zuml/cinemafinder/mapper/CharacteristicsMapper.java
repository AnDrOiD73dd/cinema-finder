package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;

public interface CharacteristicsMapper {

    String mapLanguage(final Language language);

    String mapRegion(final Region region);

    String mapLogoSize(final LogoSize logoSize);
}

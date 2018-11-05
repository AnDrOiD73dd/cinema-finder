package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.MovieModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieResult;

import java.util.List;

public interface MovieMapper {

    List<MovieModel> mapMovieResults(final List<MovieResult> movieResults, final Language language,
                                     final LogoSize logoSize);

    MovieModel mapMovieResult(final MovieResult movieResult, final Language language,
                              final LogoSize logoSize);
}

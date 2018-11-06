package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieResult;

import java.util.List;

public interface MovieMapper {

    List<MovieListModel> mapMovieResults(final List<MovieResult> movieResults, final Language language,
                                         final LogoSize logoSize);

    MovieListModel mapMovieResult(final MovieResult movieResult, final Language language,
                                  final LogoSize logoSize);
}

package com.ateam.zuml.cinemafinder.interactor.movie;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public final class GetUpcomingMoviesUseCase {
    private final MoviesRepository moviesRepository;

    @Inject
    GetUpcomingMoviesUseCase(final MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public Single<List<MovieListModel>> execute(final String page, final Language language,
                                                final Region region, final LogoSize logoSize) {
        return moviesRepository.getUpcomingMovies(page, language, region, logoSize);
    }


}

package com.ateam.zuml.cinemafinder.movies;

import com.ateam.zuml.cinemafinder.mapper.CharacteristicsMapper;
import com.ateam.zuml.cinemafinder.mapper.MovieMapper;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.characteristic.Region;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.repository.MoviesRepository;
import com.ateam.zuml.cinemafinder.service.api.ApiService;
import com.ateam.zuml.cinemafinder.service.model.movie.lists.MoviesList;
import com.ateam.zuml.cinemafinder.service.model.movie.lists.MoviesListWithDates;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static com.ateam.zuml.cinemafinder.util.Constants.ACTION_GENRE_ID;
import static com.ateam.zuml.cinemafinder.util.Constants.ANIMATION_GENRE_ID;
import static com.ateam.zuml.cinemafinder.util.Constants.COMEDY_GENRE_ID;

@Singleton
public final class MoviesRepositoryImpl implements MoviesRepository {

    private final ApiService apiService;
    private final MovieMapper movieMapper;
    private final CharacteristicsMapper characteristicsMapper;

    @Inject
    MoviesRepositoryImpl(final ApiService apiService, final MovieMapper movieMapper,
                         final CharacteristicsMapper characteristicsMapper) {
        this.apiService = apiService;
        this.movieMapper = movieMapper;
        this.characteristicsMapper = characteristicsMapper;
    }

    @Override
    public Single<List<MovieListModel>> getMoviesBySearch(final String query, final String page, final Language language,
                                                          final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMovies(apiService.getSearchMovies(mappedLanguage, query, page, mappedRegion),
                language, logoSize);
    }

    @Override
    public Single<List<MovieListModel>> getPopularMovies(final String page, final Language language,
                                                         final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMovies(apiService.getPopularMovies(mappedLanguage, page, mappedRegion),
                language, logoSize);
    }

    @Override
    public Single<List<MovieListModel>> getNowPlayingMovies(final String page, final Language language,
                                                            final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMoviesWithDates(apiService.getNowPlayingMovies(mappedLanguage, page, mappedRegion),
                language, logoSize);
    }

    @Override
    public Single<List<MovieListModel>> getUpcomingMovies(final String page, final Language language,
                                                          final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMoviesWithDates(apiService.getUpcomingMovies(mappedLanguage, page, mappedRegion),
                language, logoSize);
    }

    @Override
    public Single<MovieDetailsModel> getMovieById(final String id, final Language language,
                                                  final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        return apiService.getMovieInfo(id, mappedLanguage, "")
                .subscribeOn(Schedulers.io())
                .map(movieInfo -> movieMapper.mapMovieInfo(movieInfo, logoSize));
    }

    @Override
    public Single<List<MovieListModel>> getTopRatingMovies(final String page, final Language language,
                                                           final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMovies(apiService.getTopRatedMovies(mappedLanguage, page, mappedRegion),
                language, logoSize);
    }

    @Override
    public Single<List<MovieListModel>> getActionRatingMovies(final String page, final Language language,
                                                              final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMovies(apiService.getTopRatedByGenreMovies(mappedLanguage, page, mappedRegion, ACTION_GENRE_ID),
                language, logoSize);
    }

    @Override
    public Single<List<MovieListModel>> getAnimationRatingMovies(final String page, final Language language,
                                                                 final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMovies(apiService.getTopRatedByGenreMovies(mappedLanguage, page, mappedRegion, ANIMATION_GENRE_ID),
                language, logoSize);
    }

    @Override
    public Single<List<MovieListModel>> getComedyRatingMovies(final String page, final Language language,
                                                              final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return getMappedMovies(apiService.getTopRatedByGenreMovies(mappedLanguage, page, mappedRegion, COMEDY_GENRE_ID),
                language, logoSize);
    }

    private Single<List<MovieListModel>> getMappedMovies(final Single<MoviesList> source,
                                                         final Language language,
                                                         final LogoSize logoSize) {
        return source
                .subscribeOn(Schedulers.io())
                .map(response -> Arrays.asList(response.getResults()))
                .map(movieResults -> movieMapper.mapMovieResults(movieResults, language, logoSize));
    }

    private Single<List<MovieListModel>> getMappedMoviesWithDates(final Single<MoviesListWithDates> source,
                                                                  final Language language,
                                                                  final LogoSize logoSize) {
        return source
                .subscribeOn(Schedulers.io())
                .map(response -> Arrays.asList(response.getResults()))
                .map(movieResults -> movieMapper.mapMovieResults(movieResults, language, logoSize));
    }
}

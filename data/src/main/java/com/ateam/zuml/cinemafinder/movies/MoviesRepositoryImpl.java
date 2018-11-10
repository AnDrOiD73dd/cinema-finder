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
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

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
        return apiService.getSearchMovies(mappedLanguage, query, page, mappedRegion)
                .subscribeOn(Schedulers.io())
                .map(response -> Arrays.asList(response.getResults()))
                .map(movieResults -> movieMapper.mapMovieResults(movieResults, language, logoSize));
    }

    @Override
    public Single<List<MovieListModel>> getPopularMovies(final String page, final Language language,
                                                         final Region region, final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return apiService.getPopularMovies(mappedLanguage, page, mappedRegion)
                .subscribeOn(Schedulers.io())
                .map(response -> Arrays.asList(response.getResults()))
                .map(movieResults -> movieMapper.mapMovieResults(movieResults, language, logoSize));
    }

    @Override
    public Single<List<MovieListModel>> getNowPlayingMovies(String page, Language language, Region region, LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return apiService.getNowPlayingMovies(mappedLanguage, page, mappedRegion)
                .subscribeOn(Schedulers.io())
                .map(response -> Arrays.asList(response.getMovies()))
                .map(movieResults -> movieMapper.mapMovieResults(movieResults, language, logoSize));
    }

    @Override
    public Single<List<MovieListModel>> getUpcomingMovies(String page, Language language, Region region, LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        final String mappedRegion = characteristicsMapper.mapRegion(region);
        return apiService.getUpcomingMovies(mappedLanguage, page, mappedRegion)
                .subscribeOn(Schedulers.io())
                .map(response -> Arrays.asList(response.getMovies()))
                .map(movieResults -> movieMapper.mapMovieResults(movieResults, language, logoSize));
    }

    @Override
    public Single<MovieDetailsModel> getMovieById(final String id, final Language language,
                                                  final LogoSize logoSize) {
        final String mappedLanguage = characteristicsMapper.mapLanguage(language);
        return apiService.getMovieInfo(id, mappedLanguage, "")
                .subscribeOn(Schedulers.io())
                .map(movieInfo -> movieMapper.mapMovieDetails(movieInfo, logoSize));
    }

}

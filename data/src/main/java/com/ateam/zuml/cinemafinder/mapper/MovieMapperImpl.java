package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.service.model.movie.MovieInfo;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.ateam.zuml.cinemafinder.utils.CommonConstants.EMPTY_STRING;

@Singleton
public final class MovieMapperImpl implements MovieMapper {

    private final CharacteristicsMapper characteristicsMapper;

    @Inject
    MovieMapperImpl(final CharacteristicsMapper characteristicsMapper) {
        this.characteristicsMapper = characteristicsMapper;
    }

    @Override
    public List<MovieListModel> mapMovieResults(final List<MovieResult> movieResults, final Language language,
                                                final LogoSize logoSize) {
        final List<MovieListModel> movieListModels = new ArrayList<>(movieResults.size());
        for (final MovieResult result : movieResults) {
            movieListModels.add(mapMovieResult(result, language, logoSize));
        }
        return movieListModels;
    }

    @Override
    public MovieListModel mapMovieResult(final MovieResult movieResult, final Language language,
                                         final LogoSize logoSize) {
        final String id = String.valueOf(movieResult.getId());
        final String title = movieResult.getTitle();
        final String originalTitle = movieResult.getOriginalTitle();
        final String releaseDate = movieResult.getReleaseDate();
        final String[] genres = characteristicsMapper.mapGenres(movieResult.getGenreIds(), language);
        final String voteAverage = movieResult.getVoteAverage() < 0.1f ? EMPTY_STRING :
                String.valueOf(movieResult.getVoteAverage());
        final String posterPath = movieResult.getPosterPath() == null ? EMPTY_STRING :
                characteristicsMapper.mapLogoSizeToPath(logoSize, movieResult.getPosterPath());

        return new MovieListModel(id, title, originalTitle, releaseDate, genres, voteAverage, posterPath);
    }

    @Override
    public MovieDetailsModel mapMovieDetails(final MovieInfo movieInfo, final LogoSize logoSize) {
        final String id = String.valueOf(movieInfo.getId());
        final String title = movieInfo.getTitle();
        final String originalTitle = movieInfo.getOriginalTitle();
        final String releaseDate = movieInfo.getReleaseDate();
        final String[] genres = characteristicsMapper.mapGenres(movieInfo.getGenres());
        final String voteAverage = movieInfo.getVoteAverage() < 0.1f ? EMPTY_STRING :
                String.valueOf(movieInfo.getVoteAverage());
        final String posterPath = movieInfo.getPosterPath() == null ? EMPTY_STRING :
                characteristicsMapper.mapLogoSizeToPath(logoSize, movieInfo.getPosterPath());
        final String tagline = movieInfo.getTagline() == null ? EMPTY_STRING : movieInfo.getTagline();
        final String overview = movieInfo.getOverview() == null ? EMPTY_STRING : movieInfo.getOverview();
        final String runtime = movieInfo.getRuntime() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getRuntime());
        final String budget = movieInfo.getBudget() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getBudget());
        final String revenue = movieInfo.getRevenue() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getRevenue());
        final String voteCount = movieInfo.getVoteCount() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getVoteCount());
        final boolean adult = movieInfo.isAdult();

        return new MovieDetailsModel(id, title, originalTitle, releaseDate, genres, voteAverage,
                posterPath, tagline, overview, runtime, budget, revenue, voteCount, adult);
    }
}

package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.database.room.daos.FavoritesDao;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.BaseMovieModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieInfo;
import com.ateam.zuml.cinemafinder.service.model.movie.lists.MovieResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.ateam.zuml.cinemafinder.utils.CommonConstants.EMPTY_STRING;

@Singleton
public final class MovieMapperImpl implements MovieMapper {

    private final CharacteristicsMapper characteristicsMapper;
    private final FavoritesDao favoritesDao;

    @Inject
    MovieMapperImpl(final CharacteristicsMapper characteristicsMapper, FavoritesDao favoritesDao) {
        this.characteristicsMapper = characteristicsMapper;
        this.favoritesDao = favoritesDao;
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
        final boolean isFavorite = favoritesDao.getFavoriteMovie(id) != null;

        return new MovieListModel(id, title, originalTitle, releaseDate, genres, voteAverage,
                posterPath, isFavorite);
    }

    @Override
    public MovieDetailsModel mapMovieInfo(final MovieInfo movieInfo, final LogoSize logoSize) {
        final String id = String.valueOf(movieInfo.getId());
        final String title = movieInfo.getTitle();
        final String originalTitle = movieInfo.getOriginalTitle();
        final String releaseDate = movieInfo.getReleaseDate();
        final String[] genres = characteristicsMapper.mapGenres(movieInfo.getGenres());
        final String voteAverage = movieInfo.getVoteAverage() < 0.1f ? EMPTY_STRING :
                String.valueOf(movieInfo.getVoteAverage());
        final String posterPath = movieInfo.getPosterPath() == null ? EMPTY_STRING :
                characteristicsMapper.mapLogoSizeToPath(logoSize, movieInfo.getPosterPath());
        final boolean isFavorite = favoritesDao.getFavoriteMovie(id) != null;
        final String tagline = movieInfo.getTagline() == null ? EMPTY_STRING : movieInfo.getTagline();
        final String overview = movieInfo.getOverview() == null ? EMPTY_STRING : movieInfo.getOverview();
        final String runtime = movieInfo.getRuntime() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getRuntime());
        final String budget = movieInfo.getBudget() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getBudget());
        final String revenue = movieInfo.getRevenue() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getRevenue());
        final String voteCount = movieInfo.getVoteCount() == 0 ? EMPTY_STRING : String.valueOf(movieInfo.getVoteCount());
        final boolean adult = movieInfo.isAdult();

        return new MovieDetailsModel(id, title, originalTitle, releaseDate, genres, voteAverage,
                posterPath, isFavorite, tagline, overview, runtime, budget, revenue, voteCount, adult);
    }

    @Override
    public List<MovieListModel> mapMovieEntities(final List<MovieEntity> movieEntities) {
        final List<MovieListModel> movieListModels = new ArrayList<>(movieEntities.size());
        for (final MovieEntity movieEntity : movieEntities) {
            movieListModels.add(mapMovieEntity(movieEntity));
        }
        return movieListModels;
    }

    @Override
    public MovieListModel mapMovieEntity(final MovieEntity movieEntity) {
        final String id = String.valueOf(movieEntity.getId());
        final String title = movieEntity.getTitle();
        final String originalTitle = movieEntity.getOriginalTitle();
        final String releaseDate = movieEntity.getReleaseDate();
        final String[] genres = getGenres(movieEntity.getGenres());
        final String voteAverage = movieEntity.getVoteAverage();
        final String posterPath = movieEntity.getPosterPath();
        final boolean isFavorite = favoritesDao.getFavoriteMovie(id) != null;

        return new MovieListModel(id, title, originalTitle, releaseDate, genres, voteAverage,
                posterPath, isFavorite);
    }

    private String[] getGenres(final List<String> genres) {
        final String[] result = new String[genres.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = genres.get(i);
        }
        return result;
    }

    @Override
    public MovieEntity mapMovieModel(final BaseMovieModel movieModel) {
        final int id = Integer.parseInt(movieModel.getId());
        final String title = movieModel.getTitle();
        final String originalTitle = movieModel.getOriginalTitle();
        final String releaseDate = movieModel.getReleaseDate();
        final List<String> genres = Arrays.asList(movieModel.getGenres());
        final String voteAverage = movieModel.getVoteAverage();
        final String posterPath = getPosterPath(movieModel.getPosterPath());

        return new MovieEntity(id, title, originalTitle, posterPath, releaseDate, voteAverage, genres);
    }

    private String getPosterPath(final String path) {
        final String[] splitPath = path.split("/");
        final String logoPath = "/" + splitPath[splitPath.length - 1];
        return characteristicsMapper.mapLogoSizeToPath(LogoSize.W_154, logoPath);
    }
}

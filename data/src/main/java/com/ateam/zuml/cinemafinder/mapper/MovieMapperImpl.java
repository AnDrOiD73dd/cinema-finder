package com.ateam.zuml.cinemafinder.mapper;

import com.ateam.zuml.cinemafinder.database.room.model.favorite.FavoriteEntity;
import com.ateam.zuml.cinemafinder.database.room.model.movie.MovieEntity;
import com.ateam.zuml.cinemafinder.model.characteristic.Language;
import com.ateam.zuml.cinemafinder.model.characteristic.LogoSize;
import com.ateam.zuml.cinemafinder.model.movie.MovieDetailsModel;
import com.ateam.zuml.cinemafinder.model.movie.MovieListModel;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieInfo;
import com.ateam.zuml.cinemafinder.service.model.movie.lists.MovieResult;

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

    @Override
    public List<MovieDetailsModel> mapMovieDetailsFromMovieEntity(List<MovieEntity> movieEntities, final LogoSize logoSize) {
        final List<MovieDetailsModel> movieDetailsModels = new ArrayList<>(movieEntities.size());

        for (final MovieEntity entity : movieEntities) {
            final String id = String.valueOf(entity.getId());
            final String title = entity.getTitle();
//            final String originalTitle = entity.getOriginalTitle();
//            final String releaseDate = entity.getReleaseDate();
//            final String[] genres = characteristicsMapper.mapGenres(entity.getGenres());
            final String voteAverage = entity.getVoteAverage() < 0.1f ? EMPTY_STRING :
                    String.valueOf(entity.getVoteAverage());
            final String posterPath = entity.getPosterPath() == null ? EMPTY_STRING :
                    characteristicsMapper.mapLogoSizeToPath(logoSize, entity.getPosterPath());
            final String tagline = entity.getTagline() == null ? EMPTY_STRING : entity.getTagline();
            final String overview = entity.getOverview() == null ? EMPTY_STRING : entity.getOverview();
            final String runtime = entity.getRuntime() == 0 ? EMPTY_STRING : String.valueOf(entity.getRuntime());
//            final String budget = entity.getBudget() == 0 ? EMPTY_STRING : String.valueOf(entity.getBudget());
//            final String revenue = entity.getRevenue() == 0 ? EMPTY_STRING : String.valueOf(entity.getRevenue());
            final String voteCount = entity.getVoteCount() == 0 ? EMPTY_STRING : String.valueOf(entity.getVoteCount());
            final boolean adult = entity.isAdult();

//            movieDetailsModels.add(new MovieDetailsModel(id, title, originalTitle, releaseDate, genres, voteAverage,
//                    posterPath, tagline, overview, runtime, budget, revenue, voteCount, adult));
            movieDetailsModels.add(new MovieDetailsModel(id, title, " ", " ", new String[]{"1", "2"}, voteAverage,
                    posterPath, tagline, overview, runtime, " ", " ", voteCount, adult));
        }

        return movieDetailsModels;
    }

    @Override
    public FavoriteEntity mapFavoriteEntityFromMovieDetailsModel(final MovieDetailsModel movieDetailsModel) {
        return new FavoriteEntity(1, Integer.parseInt(movieDetailsModel.getId()));
    }
}

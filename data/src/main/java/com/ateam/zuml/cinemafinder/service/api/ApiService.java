package com.ateam.zuml.cinemafinder.service.api;

import com.ateam.zuml.cinemafinder.BuildConfig;
import com.ateam.zuml.cinemafinder.service.model.common.genre.GenresList;
import com.ateam.zuml.cinemafinder.service.model.configuration.Configuration;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieInfo;
import com.ateam.zuml.cinemafinder.service.model.movie.lists.MoviesList;
import com.ateam.zuml.cinemafinder.service.model.movie.lists.MoviesListWithDates;
import com.ateam.zuml.cinemafinder.service.model.person.credits.Credits;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String ACCESS_TOKEN = BuildConfig.ACCESS_TOKEN;

    /*
     * Search for movies.
     *
     * Required:
     * String api_key - API Key
     * String query - Pass a text query to search. This value should be URI encoded.
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * int page - Specify which page to query. minimum: 1, maximum: 1000, default: 1
     * String region - Specify a ISO 3166-1 code to filter release dates. Must be uppercase. pattern: ^[A-Z]{2}$
     *
     * Examples:
     * https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&language=en-US&query=Iron%20Man&page=1&include_adult=false&region=en-US
     * https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&language=en-US&query=Matrix&page=1&include_adult=false&region=en-US
     */
    @GET("search/movie?api_key=" + ACCESS_TOKEN)
    Single<MoviesList> getSearchMovies(@Query("language") String language,
                                       @Query("query") String query,
                                       @Query("page") String page,
                                       @Query("region") String region);

    /*
     * Get the primary information about a movie.
     *
     * Required:
     * String api_key - API Key
     * int movie_id - Given movie ID
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * String append_to_response - Specify to query additional data
     *
     * Examples:
     * https://api.themoviedb.org/3/movie/534?api_key=<<api_key>>&language=ru-ru
     * https://api.themoviedb.org/3/movie/534?api_key=<<api_key>>&language=en-US&append_to_response=videos,images
     */
    @GET("movie/{movie_id}?api_key=" + ACCESS_TOKEN)
    Single<MovieInfo> getMovieInfo(@Path("movie_id") String movieId,
                                   @Query("language") String language,
                                   @Query("append_to_response") String additionalData);

    /*
     * Get a list of movies in theatres. This is a release type query that looks for all movies
     * that have a release type of 2 or 3 within the specified date range. You can optionally
     * specify a region parameter which will narrow the search to only look for theatrical release
     * dates within the specified country.
     *
     * Required:
     * String api_key - API Key
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * int page - Specify which page to query. minimum: 1, maximum: 1000, default: 1
     * String region - Specify a ISO 3166-1 code to filter release dates. Must be uppercase. pattern: ^[A-Z]{2}$
     *
     * Example:
     * https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>&language=ru-RU&page=1&region=ru
     */
    @GET("movie/now_playing?api_key=" + ACCESS_TOKEN)
    Single<MoviesListWithDates> getNowPlayingMovies(@Query("language") String language,
                                                    @Query("page") String page,
                                                    @Query("region") String region);

    /*
     * Get a list of the current popular movies on TMDb. This list updates daily.
     *
     * Required:
     * String api_key - API Key
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * int page - Specify which page to query. minimum: 1, maximum: 1000, default: 1
     * String region - Specify a ISO 3166-1 code to filter release dates. Must be uppercase. pattern: ^[A-Z]{2}$
     *
     * Example:
     * https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=ru-RU&page=1&region=ru
     */
    @GET("movie/popular?api_key=" + ACCESS_TOKEN)
    Single<MoviesList> getPopularMovies(@Query("language") String language,
                                        @Query("page") String page,
                                        @Query("region") String region);

    /*
     * Get a list of upcoming movies in theatres.
     * This is a release type query that looks for all movies that have a release type of 2 or 3 within the
     * specified date range.
     *
     * Required:
     * String api_key - API Key
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * int page - Specify which page to query. minimum: 1, maximum: 1000, default: 1
     * String region - Specify a ISO 3166-1 code to filter release dates. Must be uppercase. pattern: ^[A-Z]{2}$
     *
     * Example:
     * https://api.themoviedb.org/3/movie/upcoming?api_key=<<api_key>>&language=ru-RU&page=1&region=ru
     *
     */
    @GET("movie/upcoming?api_key=" + ACCESS_TOKEN)
    Single<MoviesListWithDates> getUpcomingMovies(@Query("language") String language,
                                                  @Query("page") String page,
                                                  @Query("region") String region);

    /*
     * Get the top rated movies on TMDb.
     *
     * Required:
     * String api_key - API Key
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * int page - Specify which page to query. minimum: 1, maximum: 1000, default: 1
     * String region - Specify a ISO 3166-1 code to filter release dates. Must be uppercase. pattern: ^[A-Z]{2}$
     *
     * Example:
     * https://api.themoviedb.org/3/movie/top_rated?api_key=<<api_key>>&language=ru-RU&page=1&region=ru
     *
     */
    @GET("movie/top_rated?api_key=" + ACCESS_TOKEN)
    Single<MoviesList> getTopRatedMovies(@Query("language") String language,
                                                  @Query("page") String page,
                                                  @Query("region") String region);

    /*
     * Get the top rated movies by genre on TMDb.
     *
     * Required:
     * String api_key - API Key
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * int page - Specify which page to query. minimum: 1, maximum: 1000, default: 1
     * String region - Specify a ISO 3166-1 code to filter release dates. Must be uppercase. pattern: ^[A-Z]{2}$
     *
     * Example:
     * https://api.themoviedb.org/3/discover/movie?api_key=<<api_key>>&language=ru-RU&region=ru
     * &sort_by=vote_average.desc&page=1&vote_count.gte=5&with_genres=28
     *
     */
    @GET("movie/top_rated?api_key=" + ACCESS_TOKEN + "&sort_by=vote_average.desc&vote_count.gte=10")
    Single<MoviesList> getTopRatedByGenreMovies(@Query("language") String language,
                                                         @Query("page") String page,
                                                         @Query("region") String region,
                                                         @Query("with_genres") String genreId);

    /*
     * Get the cast and crew for a movie.
     *
     * Required:
     * String api_key - API Key
     * int movie_id - Given movie ID
     *
     * Optional: none
     *
     * Examples:
     * https://api.themoviedb.org/3/movie/{movie_id}/credits?api_key=<<api_key>>
     */
    @GET("movie/{movie_id}/credits?api_key=" + ACCESS_TOKEN)
    Single<Credits> getMovieCredits(@Path("movie_id") int movieId);

    /*
     * Get the list of official genres for movies.
     *
     * Required:
     * String api_key - API Key
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     *
     * Examples:
     * https://api.themoviedb.org/3/genre/movie/list?api_key=<<api_key>>&language=en-US
     */
    @GET("genre/movie/list?api_key=" + ACCESS_TOKEN)
    Single<GenresList> getGenres(@Query("language") String language);

    /*
     * Get the system wide configuration information. Some elements of the API require some
     * knowledge of this configuration data. The purpose of this is to try and keep the actual API
     * responses as light as possible. It is recommended you cache this data within your application
     * and check for updates every few days.
     *
     * This method currently holds the data relevant to building image URLs as well as the change key map.
     *
     * To build an image URL, you will need 3 pieces of data. The base_url, size and file_path.
     * Simply combine them all and you will have a fully qualified URL. Here’s an example URL:
     *
     * https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg
     *
     * The configuration method also contains the list of change keys which can be useful if you are
     * building an app that consumes data from the change feed.
     *
     * Required:
     * String api_key - API Key
     *
     * Examples:
     * https://api.themoviedb.org/3/configuration?api_key=<<api_key>>
     */
    @GET("configuration?api_key=" + ACCESS_TOKEN)
    Single<Configuration> getConfiguration();


}

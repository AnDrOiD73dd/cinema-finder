package com.ateam.zuml.cinemafinder.service.api;

import com.ateam.zuml.cinemafinder.service.model.configuration.Configuration;
import com.ateam.zuml.cinemafinder.service.model.movie.GenresList;
import com.ateam.zuml.cinemafinder.service.model.movie.MovieInfo;
import com.ateam.zuml.cinemafinder.service.model.movie.details.MovieBySearch;
import com.ateam.zuml.cinemafinder.service.model.movie.details.NowPlayingMovies;
import com.ateam.zuml.cinemafinder.service.model.movie.details.PopularMovies;
import com.ateam.zuml.cinemafinder.service.model.person.PersonInfo;
import com.ateam.zuml.cinemafinder.service.model.person.credits.Credits;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String ACCESS_TOKEN = "6951767fd82df6dc250442aa410c968e";

    // String BASE_ADDRESS = "https://api.themoviedb.org/3"

    /*
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
    Single<MovieBySearch> getSearchMovies(@Query("language") String language,
                                          @Query("query") String query,
                                          @Query("page") String page,
                                          @Query("region") String region);

    /*
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
    Single<NowPlayingMovies> getNowPlayingMovies(@Query("language") String language,
                                                 @Query("page") String page,
                                                 @Query("region") String region);

    /*
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
    Single<PopularMovies> getPopularMovies(@Query("language") String language,
                                           @Query("page") String page,
                                           @Query("region") String region);

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
     * Get the credits (cast and crew) that have been added to a TV show.
     *
     * Required:
     * String api_key - API Key
     * int movie_id - Given TV ID
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     *
     * Examples:
     * https://api.themoviedb.org/3/tv/{tv_id}/credits?api_key=<<api_key>>&language=en-US
     */
    @GET("tv/{tv_id}/credits?api_key=" + ACCESS_TOKEN)
    Single<Credits> getTVCredits(@Path("tv_id") int tvId,
                                 @Query("language") String language);

    /*
     * Get the credits (cast, crew and guest stars) for a TV episode.
     *
     * Required:
     * String api_key - API Key
     * int movie_id - Given TV Episode ID
     * int season_number - Given season number
     * int episode_number - Given episode inner number
     *
     * Optional: none
     *
     * Examples:
     * https://api.themoviedb.org/3/tv/{tv_id}/season/{season_number}/episode/{episode_number}/credits?api_key=<<api_key>>
     */
    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/credits?api_key=" + ACCESS_TOKEN)
    Single<Credits> getTVEpisodeCredits(@Path("tv_id") int tvId,
                                        @Path("season_number") int seasonNumber,
                                        @Path("episode_number") int episodeNumber);

    /*
     * Required:
     * String api_key - API Key
     * int movie_id - Given person ID
     *
     * Optional:
     * String language - Pass a ISO 639-1 value to display translated data for the fields that support it.
     * String append_to_response - Specify to query additional data
     *
     * Examples:
     * https://api.themoviedb.org/3/person/{person_id}?api_key=<<api_key>>&language=en-US
     * https://api.themoviedb.org/3/person/6885?api_key=6951767fd82df6dc250442aa410c968e&language=en-US&append_to_response=images
     */
    @GET("person/{person_id}?api_key=" + ACCESS_TOKEN)
    Single<PersonInfo> getPeople(@Path("person_id") int personId,
                                 @Query("language") String language,
                                 @Query("append_to_response") String additionalData);

    /*
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
     * To build an image URL, you will need 3 pieces of data. The base_url, size and file_path.
     * Simply combine them all and you will have a fully qualified URL. Here’s an example URL:
     * https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg
     * Required:
     * String api_key - API Key
     *
     * Examples:
     * https://api.themoviedb.org/3/configuration?api_key=<<api_key>>
     */
    @GET("configuration?api_key=" + ACCESS_TOKEN)
    Single<Configuration> getConfiguration();
}

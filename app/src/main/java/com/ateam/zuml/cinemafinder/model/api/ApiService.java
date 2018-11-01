package com.ateam.zuml.cinemafinder.model.api;

import com.ateam.zuml.cinemafinder.model.entities.Credits;
import com.ateam.zuml.cinemafinder.model.entities.Movie;
import com.ateam.zuml.cinemafinder.model.entities.NowPlayingMovies;
import com.ateam.zuml.cinemafinder.model.entities.Person;
import com.ateam.zuml.cinemafinder.model.entities.PopularMovies;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    // String BASE_ADDRESS = "https://api.themoviedb.org/3"

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
    @GET("/movie/{movie_id}")
    Single<Movie> getMovieInfo(@Path("movie_id") int movieId,
                       @Query("api_key") String accessToken,
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
    @GET("/movie/now_playing")
    Single<NowPlayingMovies> getNowPlayingMovies(@Query("api_key") String accessToken,
                                         @Query("language") String language,
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
    @GET("/movie/popular")
    Single<PopularMovies> getPopularMovies(@Query("api_key") String accessToken,
                                           @Query("language") String language,
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
    @GET("/movie/{movie_id}/credits")
    Single<Credits> getMovieCredits(@Path("movie_id") int movieId,
                            @Query("api_key") String accessToken);

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
    @GET("/tv/{tv_id}/credits")
    Single<Credits> getTVCredits(@Path("tv_id") int tvId,
                         @Query("api_key") String accessToken,
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
    @GET("/tv/{tv_id}/season/{season_number}/episode/{episode_number}/credits")
    Single<Credits> getTVEpisodeCredits(@Path("tv_id") int tvId,
                                       @Path("season_number") int seasonNumber,
                                       @Path("episode_number") int episodeNumber,
                                       @Query("api_key") String accessToken);

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
    @GET("/person/{person_id}")
    Single<Person> getPeople(@Path("person_id") int personId,
                             @Query("api_key") String accessToken,
                             @Query("language") String language,
                             @Query("append_to_response") String additionalData);
}

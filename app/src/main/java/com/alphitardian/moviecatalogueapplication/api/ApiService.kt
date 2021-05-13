package com.alphitardian.moviecatalogueapplication.api

import com.alphitardian.moviecatalogueapplication.model.remote.MovieResponse
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemMovie
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemTvShow
import com.alphitardian.moviecatalogueapplication.model.remote.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("tv/top_rated")
    fun getTopRatedTvShows(@Query("api_key") apiKey: String): Call<TvShowResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<ResultsItemMovie>

    @GET("tv/{tv_id}")
    fun getTvShowsDetail(
        @Path("tv_id") tvId: String,
        @Query("api_key") apiKey: String,
    ): Call<ResultsItemTvShow>
}
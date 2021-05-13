package com.alphitardian.moviecatalogueapplication.model

import androidx.lifecycle.LiveData

interface MovieDataSource {
    fun getTopRatedMovies() : LiveData<List<ShowEntity>>
    fun getTopRatedTvShows() : LiveData<List<ShowEntity>>
    fun getMovieDetail(movieId : String) : LiveData<ShowEntity>
    fun getTvShowDetail(showId : String) : LiveData<ShowEntity>
}
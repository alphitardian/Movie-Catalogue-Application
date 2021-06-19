package com.alphitardian.moviecatalogueapplication.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.vo.Resource

interface MovieDataSource {
    fun getTopRatedMovies(): LiveData<Resource<PagedList<ShowEntity>>>
    fun getTopRatedTvShows(): LiveData<Resource<PagedList<ShowEntity>>>
    fun getMovieDetail(movieId: String): LiveData<ShowEntity>
    fun getTvShowDetail(showId: String): LiveData<ShowEntity>
    fun getFavoriteMovie(): LiveData<PagedList<ShowEntity>>
    fun getFavoriteTvShow(): LiveData<PagedList<ShowEntity>>
    fun setFavoriteShow(show: ShowEntity, state: Boolean)
}
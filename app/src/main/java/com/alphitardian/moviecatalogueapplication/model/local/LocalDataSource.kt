package com.alphitardian.moviecatalogueapplication.model.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.model.local.room.ShowDao

class LocalDataSource private constructor(private val showDao: ShowDao) {
    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(showDao: ShowDao): LocalDataSource = instance ?: LocalDataSource(showDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, ShowEntity> = showDao.getAllMovies()

    fun getAllTvShow(): DataSource.Factory<Int, ShowEntity> = showDao.getAllTvShows()

    fun getMovieDetail(movieId: String): LiveData<ShowEntity> = showDao.getMovieDetail(movieId)

    fun getTvShowDetail(showId: String): LiveData<ShowEntity> = showDao.getTvShowDetail(showId)

    fun getFavoriteMovie(): DataSource.Factory<Int, ShowEntity> = showDao.getFavoriteMovie()

    fun getFavoriteTvShow(): DataSource.Factory<Int, ShowEntity> = showDao.getTvShowFavorite()

    fun setFavoriteShow(movie: ShowEntity, newState: Boolean) {
        movie.isFavorite = newState
        showDao.updateShow(movie)
    }

    fun insertShow(show: List<ShowEntity>) = showDao.insertShow(show)
}
package com.alphitardian.moviecatalogueapplication.model.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity

@Dao
interface ShowDao {

    @Query("SELECT * FROM showentities WHERE is_movie = 1")
    fun getAllMovies(): DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM showentities WHERE is_movie = 0")
    fun getAllTvShows(): DataSource.Factory<Int, ShowEntity>

    @Transaction
    @Query("SELECT * FROM showentities WHERE id = :movieId AND is_movie = 1")
    fun getMovieDetail(movieId: String): LiveData<ShowEntity>

    @Transaction
    @Query("SELECT * FROM showentities WHERE id = :tvShowId AND is_movie = 0")
    fun getTvShowDetail(tvShowId: String): LiveData<ShowEntity>

    @Query("SELECT * FROM showentities WHERE is_movie = 1 AND is_favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM showentities WHERE is_movie = 0 AND is_favorite = 1")
    fun getTvShowFavorite(): DataSource.Factory<Int, ShowEntity>

    @Update
    fun updateShow(show: ShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShow(show: List<ShowEntity>)
}
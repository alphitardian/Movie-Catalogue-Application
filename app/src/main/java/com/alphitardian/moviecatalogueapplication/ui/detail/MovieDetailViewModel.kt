package com.alphitardian.moviecatalogueapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity

class MovieDetailViewModel(private val movieReposity: MovieReposity) : ViewModel() {

    private var showId = MutableLiveData<String>()
    private var isMovie: Boolean? = null

    var movieResource : LiveData<ShowEntity> = Transformations.switchMap(showId) {
        movieReposity.getMovieDetail(it)
    }

    var tvShowResource : LiveData<ShowEntity> = Transformations.switchMap(showId) {
        movieReposity.getTvShowDetail(it)
    }

    fun getIsMovie(isMovie: Boolean) {
        this.isMovie = isMovie
    }

    fun setSelectedShow(showId: String) {
        this.showId.value = showId
    }

    fun getShow(): LiveData<ShowEntity> {
        lateinit var show: MutableLiveData<ShowEntity>

        if (isMovie == true) {
            show = movieResource as MutableLiveData<ShowEntity>
        } else {
            show = tvShowResource as MutableLiveData<ShowEntity>
        }

        return show
    }

    fun setFavorite() {
        val resource = if (isMovie == true) {
            movieResource
        } else {
            tvShowResource
        }

        if (resource != null) {
            val showEntity = resource.value
            val newState = !showEntity?.isFavorite!!
            movieReposity.setFavoriteShow(showEntity, newState)
        }
    }
}
package com.alphitardian.moviecatalogueapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.ShowEntity

class MovieDetailViewModel(private val movieReposity: MovieReposity) : ViewModel() {

    private lateinit var showId: String
    private var isMovie: Boolean? = null

    fun getIsMovie(isMovie: Boolean) {
        this.isMovie = isMovie
    }

    fun setSelectedShow(showId: String) {
        this.showId = showId
    }

    fun getShow(): LiveData<ShowEntity> {
        lateinit var show: MutableLiveData<ShowEntity>

        if (isMovie == true) {
            show = movieReposity.getMovieDetail(showId) as MutableLiveData<ShowEntity>
        } else {
            show = movieReposity.getTvShowDetail(showId) as MutableLiveData<ShowEntity>
        }

        return show
    }
}
package com.alphitardian.moviecatalogueapplication.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.ShowEntity

class TvShowViewModel(private val movieReposity: MovieReposity) : ViewModel() {
    fun getShows(): LiveData<List<ShowEntity>> {
        return movieReposity.getTopRatedTvShows()
    }
}
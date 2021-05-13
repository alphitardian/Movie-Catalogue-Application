package com.alphitardian.moviecatalogueapplication.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.ShowEntity

class MovieViewModel(private val movieReposity: MovieReposity) : ViewModel() {
    fun getMovies(): LiveData<List<ShowEntity>> {
        return movieReposity.getTopRatedMovies()
    }
}
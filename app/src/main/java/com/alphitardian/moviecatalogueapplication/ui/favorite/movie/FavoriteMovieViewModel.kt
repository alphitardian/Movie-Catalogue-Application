package com.alphitardian.moviecatalogueapplication.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity

class FavoriteMovieViewModel(private val movieReposity: MovieReposity) : ViewModel() {
    fun getFavoriteMovie(): LiveData<PagedList<ShowEntity>> {
        return movieReposity.getFavoriteMovie()
    }
}
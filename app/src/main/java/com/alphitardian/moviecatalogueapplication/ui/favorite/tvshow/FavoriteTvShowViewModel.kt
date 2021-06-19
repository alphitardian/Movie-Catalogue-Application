package com.alphitardian.moviecatalogueapplication.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity

class FavoriteTvShowViewModel(private val movieReposity: MovieReposity) : ViewModel() {
    fun getFavoriteTvShow(): LiveData<PagedList<ShowEntity>> {
        return movieReposity.getFavoriteTvShow()
    }
}
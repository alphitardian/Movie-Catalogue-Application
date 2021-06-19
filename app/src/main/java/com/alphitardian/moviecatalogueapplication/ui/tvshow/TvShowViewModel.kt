package com.alphitardian.moviecatalogueapplication.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.vo.Resource

class TvShowViewModel(private val movieReposity: MovieReposity) : ViewModel() {
    fun getShows(): LiveData<Resource<PagedList<ShowEntity>>> {
        return movieReposity.getTopRatedTvShows()
    }
}
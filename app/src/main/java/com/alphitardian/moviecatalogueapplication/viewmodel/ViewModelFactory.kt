package com.alphitardian.moviecatalogueapplication.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alphitardian.moviecatalogueapplication.di.Injection
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.ui.detail.MovieDetailViewModel
import com.alphitardian.moviecatalogueapplication.ui.movie.MovieViewModel
import com.alphitardian.moviecatalogueapplication.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val movieReposity: MovieReposity) : ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieReposity) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(movieReposity) as T
            }
            modelClass.isAssignableFrom(MovieDetailViewModel::class.java) -> {
                return MovieDetailViewModel(movieReposity) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
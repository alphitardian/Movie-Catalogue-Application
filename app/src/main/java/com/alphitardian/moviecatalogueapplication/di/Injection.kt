package com.alphitardian.moviecatalogueapplication.di

import android.content.Context
import com.alphitardian.moviecatalogueapplication.api.ApiConfig
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.remote.RemoteDataSource
import com.alphitardian.moviecatalogueapplication.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : MovieReposity {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val apiConfig = ApiConfig.getInstance()
        return MovieReposity.getInstance(remoteDataSource, apiConfig)
    }
}
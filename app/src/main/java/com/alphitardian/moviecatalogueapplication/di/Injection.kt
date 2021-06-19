package com.alphitardian.moviecatalogueapplication.di

import android.content.Context
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.LocalDataSource
import com.alphitardian.moviecatalogueapplication.model.local.room.ShowDatabase
import com.alphitardian.moviecatalogueapplication.model.remote.RemoteDataSource
import com.alphitardian.moviecatalogueapplication.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): MovieReposity {
        val database = ShowDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.showDao())
        val appExecutors = AppExecutors()

        return MovieReposity.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
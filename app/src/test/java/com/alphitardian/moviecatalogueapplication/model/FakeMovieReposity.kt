package com.alphitardian.moviecatalogueapplication.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alphitardian.moviecatalogueapplication.model.remote.RemoteDataSource
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemMovie
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemTvShow

class FakeMovieReposity(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    override fun getTopRatedMovies(): LiveData<List<ShowEntity>> {
        val movieResult = MutableLiveData<List<ShowEntity>>()

        remoteDataSource.getTopRatedMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(response: List<ResultsItemMovie>) {
                val movieList = ArrayList<ShowEntity>()

                for (entity in response) {
                    val movie = ShowEntity(
                        entity.id.toString(),
                        entity.originalTitle,
                        entity.releaseDate,
                        entity.overview,
                        entity.voteAverage.toString(),
                        entity.posterPath,
                        true
                    )
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }
        })

        return movieResult
    }

    override fun getTopRatedTvShows(): LiveData<List<ShowEntity>> {
        val showResult = MutableLiveData<List<ShowEntity>>()

        remoteDataSource.getTopRatedTvShows(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllShowReceived(response: List<ResultsItemTvShow>) {
                val showList = ArrayList<ShowEntity>()

                for (entity in response) {
                    val show = ShowEntity(
                        entity.id.toString(),
                        entity.originalTitle,
                        entity.releaseDate,
                        entity.overview,
                        entity.voteAverage.toString(),
                        entity.posterPath,
                        false
                    )

                    showList.add(show)
                }
                showResult.postValue(showList)
            }
        })

        return showResult
    }

    override fun getMovieDetail(movieId: String): LiveData<ShowEntity> {
        val movieResult = MutableLiveData<ShowEntity>()

        remoteDataSource.getMovieDetail(object : RemoteDataSource.LoadMovieDetailCallback {
            override fun onMovieDetailReceived(response: ResultsItemMovie) {
                val movie = ShowEntity(
                    response.id.toString(),
                    response.originalTitle,
                    response.releaseDate,
                    response.overview,
                    response.voteAverage.toString(),
                    response.posterPath,
                    true
                )

                movieResult.postValue(movie)
            }
        }, movieId)
        return movieResult
    }

    override fun getTvShowDetail(showId: String): LiveData<ShowEntity> {
        val showResult = MutableLiveData<ShowEntity>()

        remoteDataSource.getTvShowDetail(object : RemoteDataSource.LoadTvShowDetailCallback {
            override fun onTvShowDetailReceived(response: ResultsItemTvShow) {
                val show = ShowEntity(
                    response.id.toString(),
                    response.originalTitle,
                    response.releaseDate,
                    response.overview,
                    response.voteAverage.toString(),
                    response.posterPath,
                    false
                )

                showResult.postValue(show)
            }
        }, showId)
        return showResult
    }
}
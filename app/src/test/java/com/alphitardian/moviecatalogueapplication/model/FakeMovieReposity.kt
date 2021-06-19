package com.alphitardian.moviecatalogueapplication.model

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.alphitardian.moviecatalogueapplication.model.local.LocalDataSource
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.model.remote.ApiResponse
import com.alphitardian.moviecatalogueapplication.model.remote.RemoteDataSource
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemMovie
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemTvShow
import com.alphitardian.moviecatalogueapplication.utils.AppExecutors
import com.alphitardian.moviecatalogueapplication.vo.Resource

class FakeMovieReposity(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieDataSource {

    override fun getTopRatedMovies(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ShowEntity>, List<ResultsItemMovie>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemMovie>>> {
                return remoteDataSource.getTopRatedMovies()
            }

            override fun saveCallResult(data: List<ResultsItemMovie>) {
                val movieList = ArrayList<ShowEntity>()

                for (entity in data) {
                    val movie = ShowEntity(
                        entity.id.toString(),
                        entity.originalTitle,
                        entity.releaseDate,
                        entity.overview,
                        entity.voteAverage.toString(),
                        entity.posterPath,
                        true,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertShow(movieList)
            }
        }.asLiveData()
    }

    override fun getTopRatedTvShows(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ShowEntity>, List<ResultsItemTvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<ResultsItemTvShow>>> {
                return remoteDataSource.getTopRatedTvShows()
            }

            override fun saveCallResult(data: List<ResultsItemTvShow>) {
                val showList = ArrayList<ShowEntity>()

                for (entity in data) {
                    val show = ShowEntity(
                        entity.id.toString(),
                        entity.originalTitle,
                        entity.releaseDate,
                        entity.overview,
                        entity.voteAverage.toString(),
                        entity.posterPath,
                        false,
                        false
                    )
                    showList.add(show)
                }
                localDataSource.insertShow(showList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: String): LiveData<ShowEntity> {
        return localDataSource.getMovieDetail(movieId)
    }

    override fun getTvShowDetail(showId: String): LiveData<ShowEntity> {
        return localDataSource.getTvShowDetail(showId)
    }

    override fun getFavoriteMovie(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun setFavoriteShow(show: ShowEntity, state: Boolean) {
        return appExecutors.diskIO().execute {
            localDataSource.setFavoriteShow(show, state)
        }
    }
}
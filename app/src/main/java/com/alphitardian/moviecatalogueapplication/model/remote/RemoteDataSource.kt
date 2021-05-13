package com.alphitardian.moviecatalogueapplication.model.remote

import android.util.Log
import com.alphitardian.moviecatalogueapplication.api.ApiConfig
import com.alphitardian.moviecatalogueapplication.utils.EspressoIdlidngResource
import com.alphitardian.moviecatalogueapplication.utils.JsonHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper).apply {
                instance = this
            }
        }
    }

    fun getTopRatedMovies(callback: LoadMovieCallback) {
        EspressoIdlidngResource.increment()
        ApiConfig.getApiService().getTopRatedMovies(ApiConfig.API_KEY).enqueue(object :
            Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    callback.onAllMovieReceived(
                        response.body()?.results!!
                    )
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })
    }

    fun getTopRatedTvShows(callback: LoadTvShowCallback) {
        EspressoIdlidngResource.increment()
        ApiConfig.getApiService().getTopRatedTvShows(ApiConfig.API_KEY).enqueue(object :
            Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    callback.onAllShowReceived(
                        response.body()?.results!!
                    )
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })
    }

    fun getMovieDetail(callback: LoadMovieDetailCallback, movieId: String) {
        EspressoIdlidngResource.increment()
        ApiConfig.getApiService().getMovieDetail(movieId, ApiConfig.API_KEY).enqueue(object :
            Callback<ResultsItemMovie> {
            override fun onResponse(
                call: Call<ResultsItemMovie>,
                response: Response<ResultsItemMovie>
            ) {
                if (response.isSuccessful) {
                    callback.onMovieDetailReceived(
                        response.body()!!
                    )
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<ResultsItemMovie>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })
    }

    fun getTvShowDetail(callback: LoadTvShowDetailCallback, showId: String) {
        EspressoIdlidngResource.increment()
        ApiConfig.getApiService().getTvShowsDetail(showId, ApiConfig.API_KEY).enqueue(object :
            Callback<ResultsItemTvShow> {
            override fun onResponse(
                call: Call<ResultsItemTvShow>,
                response: Response<ResultsItemTvShow>
            ) {
                if (response.isSuccessful) {
                    callback.onTvShowDetailReceived(
                        response.body()!!
                    )
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<ResultsItemTvShow>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })
    }

    public interface LoadMovieCallback {
        fun onAllMovieReceived(response: List<ResultsItemMovie>)
    }

    public interface LoadTvShowCallback {
        fun onAllShowReceived(response: List<ResultsItemTvShow>)
    }

    public interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(response: ResultsItemMovie)
    }

    public interface LoadTvShowDetailCallback {
        fun onTvShowDetailReceived(response: ResultsItemTvShow)
    }
}
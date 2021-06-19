package com.alphitardian.moviecatalogueapplication.model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alphitardian.moviecatalogueapplication.BuildConfig
import com.alphitardian.moviecatalogueapplication.api.ApiConfig
import com.alphitardian.moviecatalogueapplication.utils.EspressoIdlidngResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor() {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource().apply {
                instance = this
            }
        }
    }

    fun getTopRatedMovies(): LiveData<ApiResponse<List<ResultsItemMovie>>> {
        EspressoIdlidngResource.increment()

        val resultMovie = MutableLiveData<ApiResponse<List<ResultsItemMovie>>>()
        ApiConfig.getApiService().getTopRatedMovies(BuildConfig.API_KEY).enqueue(object :
            Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    resultMovie.value = ApiResponse.success(response.body()?.results!!)
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })

        return resultMovie
    }

    fun getTopRatedTvShows(): LiveData<ApiResponse<List<ResultsItemTvShow>>> {
        EspressoIdlidngResource.increment()

        val resultShow = MutableLiveData<ApiResponse<List<ResultsItemTvShow>>>()
        ApiConfig.getApiService().getTopRatedTvShows(BuildConfig.API_KEY).enqueue(object :
            Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    resultShow.value = ApiResponse.success(response.body()?.results!!)
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })

        return resultShow
    }

    fun getMovieDetail(movieId: String): LiveData<ApiResponse<ResultsItemMovie>> {
        EspressoIdlidngResource.increment()

        val resultMovie = MutableLiveData<ApiResponse<ResultsItemMovie>>()
        ApiConfig.getApiService().getMovieDetail(movieId, BuildConfig.API_KEY).enqueue(object :
            Callback<ResultsItemMovie> {
            override fun onResponse(
                call: Call<ResultsItemMovie>,
                response: Response<ResultsItemMovie>
            ) {
                if (response.isSuccessful) {
                    resultMovie.value = ApiResponse.success(response.body()!!)
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<ResultsItemMovie>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })

        return resultMovie
    }

    fun getTvShowDetail(showId: String): LiveData<ApiResponse<ResultsItemTvShow>> {
        EspressoIdlidngResource.increment()

        val resultShow = MutableLiveData<ApiResponse<ResultsItemTvShow>>()
        ApiConfig.getApiService().getTvShowsDetail(showId, BuildConfig.API_KEY).enqueue(object :
            Callback<ResultsItemTvShow> {
            override fun onResponse(
                call: Call<ResultsItemTvShow>,
                response: Response<ResultsItemTvShow>
            ) {
                if (response.isSuccessful) {
                    resultShow.value = ApiResponse.success(response.body()!!)
                    EspressoIdlidngResource.decrement()
                }
            }

            override fun onFailure(call: Call<ResultsItemTvShow>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: " + t)
            }
        })

        return resultShow
    }
}
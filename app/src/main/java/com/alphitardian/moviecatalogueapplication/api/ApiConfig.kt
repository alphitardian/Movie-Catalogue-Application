package com.alphitardian.moviecatalogueapplication.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "292a00af87bd9fbb9bf1fa58143d4738"

        private var instance : ApiConfig? = null

        fun getInstance(): ApiConfig = ApiConfig.instance ?: synchronized(this) {
            ApiConfig.instance ?: ApiConfig().apply {
                ApiConfig.instance = this
            }
        }

        fun getApiService() : ApiService {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
package com.alphitardian.moviecatalogueapplication.utils

import android.content.Context
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemMovie
import com.alphitardian.moviecatalogueapplication.model.remote.ResultsItemTvShow
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<ResultsItemMovie> {
        val listResult = ArrayList<ResultsItemMovie>()

        try {
            val responseObject = JSONObject(parsingFileToString("movie_response.json").toString())
            val list = responseObject.getJSONArray("results")

            for (i in 0 until list.length()) {
                val movie = list.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("original_title")
                val overview = movie.getString("overview")
                val releaseDate = movie.getString("release_date")
                val rating = movie.getDouble("vote_average")
                val imagePath = movie.getString("poster_path")

                val movieResponse =
                    ResultsItemMovie(id, title, overview, imagePath, releaseDate, rating)
                listResult.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return listResult
    }

    fun loadTvShows(): List<ResultsItemTvShow> {
        val listResult = ArrayList<ResultsItemTvShow>()

        try {
            val responseObject = JSONObject(parsingFileToString("tv_response.json").toString())
            val list = responseObject.getJSONArray("results")

            for (i in 0 until list.length()) {
                val movie = list.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("original_name")
                val overview = movie.getString("overview")
                val releaseDate = movie.getString("first_air_date")
                val rating = movie.getDouble("vote_average")
                val imagePath = movie.getString("poster_path")

                val movieResponse =
                    ResultsItemTvShow(id, title, overview, imagePath, releaseDate, rating)
                listResult.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return listResult
    }
}
package com.alphitardian.moviecatalogueapplication.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ResultsItemMovie>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

@Parcelize
data class ResultsItemMovie(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("original_title")
	val originalTitle: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double
) : Parcelable

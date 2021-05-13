package com.alphitardian.moviecatalogueapplication.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class TvShowResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<ResultsItemTvShow>,

	@field:SerializedName("total_results")
	val totalResults: Int
)

@Parcelize
data class ResultsItemTvShow(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("original_name")
	val originalTitle: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("first_air_date")
	val releaseDate: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double
) : Parcelable

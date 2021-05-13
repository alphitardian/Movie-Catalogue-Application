package com.alphitardian.moviecatalogueapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowEntity(
    var id : String,
    var title : String,
    var releaseYear : String,
    var overview : String,
    var userRating : String,
    var imagePath : String,
    var isMovie : Boolean
) : Parcelable
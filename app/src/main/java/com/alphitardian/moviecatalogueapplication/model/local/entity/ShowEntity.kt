package com.alphitardian.moviecatalogueapplication.model.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "showentities")
@Parcelize
data class ShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "release_year")
    var releaseYear: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "user_rating")
    var userRating: String,

    @ColumnInfo(name = "image_path")
    var imagePath: String,

    @ColumnInfo(name = "is_movie")
    var isMovie: Boolean,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean,
) : Parcelable
package com.alphitardian.moviecatalogueapplication.model.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity

@Database(entities = [ShowEntity::class], version = 1, exportSchema = false)
abstract class ShowDatabase : RoomDatabase() {
    abstract fun showDao(): ShowDao

    companion object {
        @Volatile
        private var instance: ShowDatabase? = null

        fun getInstance(context: Context): ShowDatabase = instance ?: synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                ShowDatabase::class.java,
                "ShowDatabase.db"
            ).build().apply {
                instance = this
            }
        }
    }
}
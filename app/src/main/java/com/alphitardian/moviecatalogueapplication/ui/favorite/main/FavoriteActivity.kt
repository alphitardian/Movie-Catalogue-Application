package com.alphitardian.moviecatalogueapplication.ui.favorite.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alphitardian.moviecatalogueapplication.R
import com.alphitardian.moviecatalogueapplication.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val favoriteSectionPagerAdapter = FavoriteSectionPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = favoriteSectionPagerAdapter
        activityFavoriteBinding.tabLayout.setupWithViewPager(activityFavoriteBinding.viewPager)

        supportActionBar?.title = getString(R.string.favorite_title)
        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
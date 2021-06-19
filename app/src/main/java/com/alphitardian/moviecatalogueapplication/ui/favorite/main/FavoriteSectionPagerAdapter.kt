package com.alphitardian.moviecatalogueapplication.ui.favorite.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alphitardian.moviecatalogueapplication.R
import com.alphitardian.moviecatalogueapplication.ui.favorite.movie.FavoriteMovieFragment
import com.alphitardian.moviecatalogueapplication.ui.favorite.tvshow.FavoriteTvShowFragment

class FavoriteSectionPagerAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitle = arrayOf(
        context.getString(R.string.movie_tab_text),
        context.getString(R.string.tvshows_tab_text)
    )

    override fun getCount(): Int {
        return tabTitle.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitle[position]
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }
    }


}
package com.alphitardian.moviecatalogueapplication.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphitardian.moviecatalogueapplication.R
import com.alphitardian.moviecatalogueapplication.databinding.FragmentTvShowBinding
import com.alphitardian.moviecatalogueapplication.ui.movie.MovieAdapter
import com.alphitardian.moviecatalogueapplication.viewmodel.ViewModelFactory
import com.alphitardian.moviecatalogueapplication.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    private lateinit var viewModel: TvShowViewModel
    private lateinit var showAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            showAdapter = MovieAdapter()

            viewModel.getShows().observe(this, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> fragmentTvShowBinding.progressBar.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            showAdapter.submitList(tvShows.data)
                            showAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                context,
                                getString(R.string.error_message_toast),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })

            fragmentTvShowBinding.tvRecyclerview.layoutManager = LinearLayoutManager(context)
            fragmentTvShowBinding.tvRecyclerview.setHasFixedSize(true)
            fragmentTvShowBinding.tvRecyclerview.adapter = showAdapter
        }
    }
}
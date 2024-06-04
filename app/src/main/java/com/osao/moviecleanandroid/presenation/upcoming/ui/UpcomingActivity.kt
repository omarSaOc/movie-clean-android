package com.osao.moviecleanandroid.presenation.upcoming.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.osao.moviecleanandroid.databinding.ActivityUpcomingBinding
import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieResponseUI
import com.osao.moviecleanandroid.presenation.upcoming.ui.adapter.UpcomingAdapter
import com.osao.moviecleanandroid.presenation.upcoming.viewmodel.UpcomingViewModel
import com.osao.moviecleanandroid.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpcomingActivity : BaseActivity() {

    private val binding by lazy {
        ActivityUpcomingBinding.inflate(layoutInflater)
    }

    private val viewModel: UpcomingViewModel by viewModels()
    private lateinit var adapter: UpcomingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        listener()
        fetchUpcomingMovies()
        observer()
    }

    private fun initView() = with(binding) {
        rvTopUpcomingMovies.layoutManager = GridLayoutManager(this@UpcomingActivity, 3)
        adapter = UpcomingAdapter { movie ->
            Toast.makeText(this@UpcomingActivity, "Movie clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun listener() = with(binding) {
        fab.setOnClickListener {
            finish()
        }

        swipeRefreshLayout.setOnRefreshListener {
            fetchUpcomingMovies()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchUpcomingMovies() {
        showLoading()
        viewModel.getUpcomingMovies()
    }

    private fun observer() {
        viewModel.upcomingMovies.observe(this, ::getUpcomingMovies)
    }

    private fun getUpcomingMovies(value: UpcomingMovieResponseUI) {
        dismissLoading()
        adapter.list = value.results
        binding.rvTopUpcomingMovies.adapter = adapter
    }
}
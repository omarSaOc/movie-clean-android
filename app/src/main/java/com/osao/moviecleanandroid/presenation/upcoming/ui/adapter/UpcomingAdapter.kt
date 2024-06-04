package com.osao.moviecleanandroid.presenation.upcoming.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osao.moviecleanandroid.R
import com.osao.moviecleanandroid.databinding.ItemUpcomingBinding
import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieUI
import com.osao.moviecleanandroid.utils.basicDiffUtil
import com.osao.moviecleanandroid.utils.inflate
import com.osao.moviecleanandroid.utils.loadUrl

class UpcomingAdapter(
    private val listener: (UpcomingMovieUI) -> Unit
) : RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    var list: List<UpcomingMovieUI> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val view = parent.inflate(R.layout.item_upcoming, false)
        return UpcomingViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    inner class UpcomingViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {

        private val binding = ItemUpcomingBinding.bind(itemView)

        fun bind(movie: UpcomingMovieUI) = with(binding) {
            tvTitleUpcomingMovie.text = movie.title
            ivUpcomingMovie.loadUrl("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
        }

    }
}
package com.osao.moviecleanandroid.presenation.popular.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osao.moviecleanandroid.R
import com.osao.moviecleanandroid.databinding.ItemPopularBinding
import com.osao.moviecleanandroid.domain.popular.models.PopularMovieUI
import com.osao.moviecleanandroid.utils.basicDiffUtil
import com.osao.moviecleanandroid.utils.inflate
import com.osao.moviecleanandroid.utils.loadUrl

class PopularAdapter(
    private val listener: (PopularMovieUI) -> Unit
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    var list: List<PopularMovieUI> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = parent.inflate(R.layout.item_popular,  false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    inner class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemPopularBinding.bind(itemView)

        fun bind(movie: PopularMovieUI) = with(binding) {
            tvTitlePopularMovie.text = movie.title
            ivPopularMovie.loadUrl("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
        }
    }
}
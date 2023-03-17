package com.example.youtubeapi.ui.playlists.playlists.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_api.extensions.glide
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.ItemplaylistsBinding
import com.example.youtubeapi.data.data.remote.model.Items


class AdapterPlaylists (
    val onClick: (Items) -> Unit
) :RecyclerView.Adapter<AdapterPlaylists.ViewHolderPlaylists>(){

    private val playlists: ArrayList<Items> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPlaylists {
        return ViewHolderPlaylists(
            ItemplaylistsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onBindViewHolder(holder: ViewHolderPlaylists, position: Int) {
            holder.bind(playlists[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setPlaylists(items : List<Items>){
        playlists.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolderPlaylists(private val binding: ItemplaylistsBinding):
        RecyclerView.ViewHolder(binding.root) {



        fun bind(items: Items) = with(binding) {
            imgItemPlaylist.glide(items.snippet.thumbnails.medium.url)
            tvItemPlaylist.text = items.snippet.title
            tvDesc.text = items.contentDetails.itemCount.toString().plus("").plus(
                itemView.context.getString(
                    R.string.video_series
                )
            )

            itemView.setOnClickListener {
                onClick(items)
            }

        }

    }

}

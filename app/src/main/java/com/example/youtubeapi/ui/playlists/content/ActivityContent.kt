package com.example.youtubeapi.ui.playlists.content

import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.databinding.ActivityContentBinding
import com.example.youtubeapi.ui.playlists.content.adapter.AdapteroContent
import com.example.youtubeapi.ui.playlists.content.adapter.ContentViewModel
import com.example.youtubeapi.ui.playlists.playlists.PlaylistActivity.Companion.KEY
import com.example.youtubeapi.utils.InternetConnection


class ActivityContent : BaseActivity<ContentViewModel, ActivityContentBinding>() {
    private lateinit var adapter: AdapteroContent
    private lateinit var internetConnection: InternetConnection

    override val viewModel: ContentViewModel by lazy {
        ViewModelProvider(this)[ContentViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityContentBinding {
        return ActivityContentBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        super.checkInternet()
        internetConnection = InternetConnection(application = application)
        internetConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.noInternet.root.visibility = View.GONE

            } else {
                binding.noInternet.root.visibility = View.VISIBLE
            }

        }
    }


    override fun initView() {
        adapter = AdapteroContent()
        val id = intent.getStringExtra(KEY)
        id?.let { _ ->
            viewModel.getContent(id).observe(this) {
                binding.rvContent.adapter = adapter

                it.data?.let { it1 -> adapter.setItems(it1.items) }

            }
        }

    }

}
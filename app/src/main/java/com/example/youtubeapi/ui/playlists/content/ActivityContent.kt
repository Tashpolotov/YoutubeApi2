package com.example.youtubeapi.ui.playlists.content

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtube_api.base.BaseActivity
import com.example.youtube_api.extensions.showToast
import com.example.youtubeapi.databinding.ActivityContentBinding
import com.example.youtubeapi.ui.playlists.PlaylistActivity.Companion.KEY
import com.example.youtubeapi.ui.playlists.PlaylistsViewModel


class ActivityContent : BaseActivity<PlaylistsViewModel, ActivityContentBinding>(){

    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityContentBinding {
        return ActivityContentBinding.inflate(layoutInflater)
    }

    override fun initView() {
        showToast("${intent.getStringExtra(KEY)}")
    }

    override fun initListener() {
        binding.include.tvToolbar.setOnClickListener{
            this.onBackPressed()
        }
    }
}
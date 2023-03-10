package com.example.youtubeapi.ui.playlists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.youtube_api.base.BaseActivity
import com.example.youtube_api.extensions.showToast
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.PlaylistsMainBinding
import com.example.youtubeapi.model.Items
import com.example.youtubeapi.ui.playlists.content.ActivityContent

class PlaylistActivity : BaseActivity<PlaylistsViewModel, PlaylistsMainBinding>() {

    private lateinit var adapter: AdapterPlaylists
    private lateinit var internetConnection: InternetConnection
    private val registerForActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): PlaylistsMainBinding {
        return PlaylistsMainBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        internetConnection = InternetConnection(application = application)
        internetConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.includeInternetCheck.root.visibility = View.GONE

            } else {
                binding.includeInternetCheck.root.visibility = View.VISIBLE
            }

        }
    }

    override fun initView() {
        viewModel.playlist().observe(this) {
            adapter = AdapterPlaylists(it, this::itemClick)
            binding.rvPlaylists.adapter = adapter
        }
    }

    private fun itemClick(items: Items) {

        val intent = Intent(this, ActivityContent::class.java).apply {
            putExtra(KEY, items.id)

        }
        registerForActivity.launch(intent)

    }

    override fun initListener() {
        binding.includeInternetCheck.btnTryAgain.setOnClickListener{
            showToast("No connection")
        }
    }

    companion object{
        const val KEY="next"
    }
}

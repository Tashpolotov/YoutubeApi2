package com.example.youtubeapi.ui.playlists.playlists.adapter

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App.Companion.repository
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.data.remote.model.Playlists


class PlaylistsViewModel: BaseViewModel() {


    fun getPlaylists(): LiveData<Resource<Playlists>> {
        return repository.getPlaylist()
    }
}
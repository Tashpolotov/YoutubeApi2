package com.example.youtubeapi.ui.playlists.content.adapter

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.App.Companion.repository
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.data.remote.model.Playlists

class ContentViewModel: BaseViewModel() {

    fun getContent(id: String): LiveData<Resource<Playlists>> {
        return repository.getContent(id)
    }
}
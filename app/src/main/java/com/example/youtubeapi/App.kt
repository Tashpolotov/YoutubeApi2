package com.example.youtubeapi

import android.app.Application
import com.example.youtubeapi.repository.Repository

class App : Application(){

    companion object{

        val repository: Repository by lazy {
            Repository()
        }
            const val CHANNEL_ID = "UCWOA1ZGywLbqmigxE4Qlvuw"
            const val PART_PLAYLISTS = "snippet,contentDetails"
            const val KEY: String = "key"

    }


}
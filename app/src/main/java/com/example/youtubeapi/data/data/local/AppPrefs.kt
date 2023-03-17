package com.example.youtubeapi.data.data.local

import android.content.Context

class AppPrefs(context: Context) {

private val prefs = context.getSharedPreferences("youtube_api", Context.MODE_PRIVATE)

    var onBoard: Boolean
        get() = prefs.getBoolean("onBoard", false)
        set(value) = prefs.edit().putBoolean("onBoard", value).apply()

}
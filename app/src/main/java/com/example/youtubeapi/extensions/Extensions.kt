package com.example.youtube_api.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.youtubeapi.R

fun View.glide(url:String){
    Glide.with(this).load(url).placeholder(R.drawable.place_h).centerCrop().into(this as ImageView)
}
fun Context.showToast(text:String){
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}
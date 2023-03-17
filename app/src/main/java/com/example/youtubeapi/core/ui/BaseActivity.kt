package com.example.youtubeapi.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewbinding.ViewBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

abstract class BaseActivity<VM: BaseViewModel,VB:ViewBinding> : AppCompatActivity() {

    protected lateinit var binding:VB
    protected abstract val viewModel:VM

    protected abstract fun inflateViewBinding(inflater: LayoutInflater):VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        initViewModel()
        initView()
        initListener()

    }

    open fun checkInternet(){}

    open fun initViewModel(){}

    open fun initView(){}

    open fun initListener(){}

}
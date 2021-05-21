package com.example.mybestpractice.kotlin.sunnyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.mybestpractice.R

class MvvmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm2)
        lifecycleScope.launchWhenCreated {

        }


//        val create = ServiceCreator.create(GitHubService::class.java)
//        val create1 = ServiceCreator.create<GitHubService>()


    }
}
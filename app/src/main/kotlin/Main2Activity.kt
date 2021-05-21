package com.example.mybestpractice.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mybestpractice.R
import com.example.mybestpractice.databinding.ActivityMain2Binding
import com.example.mybestpractice.kotlin.sunnyweather.MvvmActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread
import retrofit2.Retrofit


class Main2Activity : AppCompatActivity() {
    // 匿名函数
    val stringLengthFunc: (String) -> Int = {
        it.length
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.setOnClickListener {
            startActivity(Intent(this,MvvmActivity::class.java))
        }

//        BaseApplication.currentApplication;
        Utils.toast("单参数")
        Utils.toast("双参数", Toast.LENGTH_LONG)


        // usage
       /* val jane = User(lastName = "done")   // same as User(null, "Doe")
        val john = User("John", "Doe")

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()

        val service = retrofit.create(GitHubService::class.java)

        val listRepos = service.listRepos("octocat")

        listRepos.enqueue(object : retrofit2.Callback<List<Repo>> {
            override fun onFailure(call: retrofit2.Call<List<Repo>>, t: Throwable) {
            }

            override fun onResponse(call: retrofit2.Call<List<Repo>>, response: retrofit2.Response<List<Repo>>) {
                Log.e("response", response.toString())
            }
        })*/

        /*val intArray: IntArray = intArrayOf(1, 3, 5)
        val arrayOf: Array<String> = arrayOf("我", "最", "码农")
        val array: Array<User> = arrayOf(User(lastName = "ds"), User(lastName = "dd"))
        arrayOf.size*/






    }

    // 耗时函数 1
    private suspend fun getData(): String {
        // 假设这个函数比较耗时，需要放在后台
        return withContext(Dispatchers.IO) {
            "hen_coder"
        }
    }

    // 耗时函数 2
     /*private suspend fun processData(data: String): String {
         // 假设这个函数也比较耗时，需要放在后台
         return withContext(Dispatchers.IO) {
             data.split("_") // 把 "hen_coder" 拆成 ["hen", "coder"]
                     .map { it.capitalize() } // 把 ["hen", "coder"] 改成 ["Hen", "Coder"]
                     .reduce { acc, s -> acc + s } // 把 ["Hen", "Coder"] 改成 "HenCoder"
         }

     }*/


}

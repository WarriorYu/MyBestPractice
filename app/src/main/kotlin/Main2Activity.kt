package com.example.mybestpractice.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.mybestpractice.R
import kotlinx.android.synthetic.main.activity_main2.*
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
        setContentView(R.layout.activity_main2)
        GlobalScope.launch(Dispatchers.Main) {
            val data = getData()
//            val processedData = processData(data)
            // 练习内容：用协程让上面 ↑ 这两行放在后台执行，
//            textview.text = processedData
        }

        thread {
            Thread.sleep(1000)

        }

//        BaseApplication.currentApplication;
        Utils.toast("单参数")
        Utils.toast("双参数", Toast.LENGTH_LONG)

        val client = OkHttpClient()

        val request: Request = Request.Builder().url("df").build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
            }
        })


        // usage
        val jane = User(lastName = "done")   // same as User(null, "Doe")
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
        })


    }

    // 耗时函数 1
    private suspend fun getData(): String {
        // 假设这个函数比较耗时，需要放在后台
        return withContext(Dispatchers.IO) {
            "hen_coder"
        }
    }

    // 耗时函数 2
    /* private suspend fun processData(data: String): String {
         // 假设这个函数也比较耗时，需要放在后台
         return withContext(Dispatchers.IO) {
             data.split("_") // 把 "hen_coder" 拆成 ["hen", "coder"]
                     .map { it.capitalize() } // 把 ["hen", "coder"] 改成 ["Hen", "Coder"]
                     .reduce { acc, s -> acc + s } // 把 ["Hen", "Coder"] 改成 "HenCoder"
         }

     }*/

}

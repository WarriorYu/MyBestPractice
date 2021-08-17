package com.example.mybestpractice.kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.FileUtils
import com.example.mybestpractice.databinding.ActivityMain2Binding
import com.yu.common.ActivityManager
import com.example.mybestpractice.kotlin.mycoroutineretrofit.GFActivity
import com.example.mybestpractice.kotlin.sunnyweather.MvvmActivity
import com.liulishuo.filedownloader.BaseDownloadTask
import com.liulishuo.filedownloader.FileDownloadListener
import com.liulishuo.filedownloader.FileDownloader
import kotlinx.coroutines.*
import java.io.File


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
            startActivity(Intent(this, MvvmActivity::class.java))
        }

        binding.textview2.setOnClickListener {
            startActivity(Intent(this, GFActivity::class.java))
        }

        binding.textview3.setOnClickListener {
            // 文件下载
            FileDownloader.setup(applicationContext)
            download()
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

        val job = Job()
        val scope = CoroutineScope(job)
        scope.launch { }
        job.cancel()

        runBlocking {
            val result = async {

            }.await()
            print(result)

        }

        //测试Activity管理栈
        ActivityManager.instance.addFrontBackCallback(object : ActivityManager.FrontBackCallback {
            override fun onChanged(front: Boolean) {
                Utils.toast("当前处于${front}")
            }
        })


    }

    private fun download() {
        val urls = ArrayList<String>()
        urls.add("http://img.guanfu.cn/gf-brand_edit-1623823891348-774.jpg")
        urls.add("http://img.guanfu.cn/gf-pro_banner-1558510482398-288.jpg")


        val adImgFileDir = File(externalCacheDir, "adImgs")
        FileUtils.createOrExistsDir(adImgFileDir)

        val imgPaths = ArrayList<File>()
        val img1File = File(adImgFileDir, "img1")
        val img2File = File(adImgFileDir, "img2")
        imgPaths.add(img1File)
        imgPaths.add(img2File)


        val queueTarget: FileDownloadListener = object : FileDownloadListener() {
            override fun pending(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {}
            override fun connected(
                task: BaseDownloadTask,
                etag: String,
                isContinue: Boolean,
                soFarBytes: Int,
                totalBytes: Int
            ) {
            }

            override fun progress(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {}
            override fun blockComplete(task: BaseDownloadTask) {}
            override fun retry(
                task: BaseDownloadTask,
                ex: Throwable,
                retryingTimes: Int,
                soFarBytes: Int
            ) {
            }

            override fun completed(task: BaseDownloadTask) {
                val path = task.path
                Log.e("imgPath",path)
            }
            override fun paused(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {}
            override fun error(task: BaseDownloadTask, e: Throwable) {}
            override fun warn(task: BaseDownloadTask) {}
        }


        for ((index,url) in urls.withIndex()){
            FileDownloader.getImpl().create(url)
//                .setPath(imgPaths[index].absolutePath)
                .setPath(adImgFileDir.absolutePath,true)
                .setCallbackProgressTimes(0) // 由于是队列任务, 这里是我们假设了现在不需要每个任务都回调`FileDownloadListener#progress`, 我们只关系每个任务是否完成, 所以这里这样设置可以很有效的减少ipc.
                .setListener(queueTarget)
                .asInQueueTask()
                .enqueue();
        }

        FileDownloader.getImpl().start(queueTarget, false);
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

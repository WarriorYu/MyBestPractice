package com.example.mybestpractice.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.mybestpractice.R
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

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
        Utils.toast("双参数",Toast.LENGTH_LONG)
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

package com.example.mybestpractice.kotlin.rxjava3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IntegerRes
import com.example.mybestpractice.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.schedulers.Schedulers

class Rxjava3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava3)

        val single: Single<Int> = Single.just(1)
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        val map = single.map(object : Function<Int, String> {
            override fun apply(t: Int?): String {
                return t.toString()
            }
        })
        map.subscribe(object : SingleObserver<String> {
            override fun onSuccess(t: String?) {

            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onError(e: Throwable?) {
            }

        })


        Observable.create(object:ObservableOnSubscribe<Integer>{
            override fun subscribe(emitter: ObservableEmitter<Integer>?) {
            }

        }).subscribe(object:Observer<Integer>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: Integer?) {
            }

            override fun onError(e: Throwable?) {
            }

        })

        var list = ArrayList<Int>()








    }
}

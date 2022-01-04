package com.example.mybestpractice.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.mybestpractice.R;
import com.example.mybestpractice.databinding.ActivityMvvmBinding;
import com.example.mybestpractice.mvvm.model.MyViewModel;
import com.example.mybestpractice.mvvm.model.User;

/**
 * @author : yuxibing
 * @date : 2021-02-04
 * Describe : 参考：http://liuwangshu.cn/application/jetpack/4-livedata-use.html
 */
public class MVVMActivity extends AppCompatActivity {
    private static final String TAG = MVVMActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMvvmBinding binding = ActivityMvvmBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        // Lifecycle 的使用
        //getLifecycle().addObserver(new MyObserver());

        // databinding 单向绑定

        User user = new User();
        user.name = "菜鸡";
        user.gender = "男";
        binding.setUser(user);

        //1. LiveData的基本用法
       /* MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged: " + s);
            }
        });
        mutableLiveData.postValue("发射一个数据");*/

        //2.更改LiveData中的数据
        //Transformations.map()

        /*MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged1: " + s);
            }
        });

        LiveData<String> transformedLiveData = Transformations.map(mutableLiveData, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input + "中途改的数据";
            }
        });

        transformedLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged2: " + s);
            }
        });

        mutableLiveData.postValue("我先发送一条数据");*/

        // 结果：
        // MVVMActivity: onChanged1: 我先发送一条数据
        // MVVMActivity: onChanged2: 我先发送一条数据中途改的数据


        //  Transformations.switchMap()
        /*MutableLiveData<String> mutableLiveData1 = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        MutableLiveData<Boolean> liveDataSwitch = new MutableLiveData<>();

        LiveData<String> transformedLiveData = Transformations.switchMap(liveDataSwitch, new Function<Boolean, LiveData<String>>() {
        @Override
        public LiveData<String> apply (Boolean input){
            if (input) {
                return mutableLiveData1;
            } else {
                return mutableLiveData2;
            }
        }
        });


        transformedLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged: " + s);
            }
        });

        liveDataSwitch.postValue(false);
        mutableLiveData1.postValue("发射第一种数据");
        mutableLiveData2.postValue("发射第二种数据");*/

        //输出：MVVMActivity: onChanged: 发射第二种数据


        //3. 合并多个LiveData数据源
        /*MutableLiveData<String> mutableLiveData1 = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();

        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

        mediatorLiveData.addSource(mutableLiveData1, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChange1: " + s);
            }
        });

        mediatorLiveData.addSource(mutableLiveData2, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChange1: " + s);
            }
        });

        mediatorLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged: " + s);
            }
        });


        mutableLiveData1.postValue("给第一个LiveData发送数据");*/

        // 输出：MVVMActivity: onChange1: 给第一个LiveData发送数据


        //1. ViewModel基本使用
        /*MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, s);
            }
        });*/


        //

    }


}

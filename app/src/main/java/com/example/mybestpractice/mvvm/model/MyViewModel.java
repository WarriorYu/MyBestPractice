package com.example.mybestpractice.mvvm.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author :   yuxibing
 * @date :   2021-02-04
 * Describe :
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<String> name;

    public LiveData<String> getName() {
        if (name == null) {
            name = new MutableLiveData<>();
            addName();
        }
        return name;
    }

    private void addName() {
        name.setValue("设置一个名字");
    }
}

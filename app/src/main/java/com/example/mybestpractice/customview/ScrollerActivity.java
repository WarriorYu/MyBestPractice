package com.example.mybestpractice.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mybestpractice.R;

/**
 * @author : yuxibing
 * @date : 2021-03-29
 * Describe : 通过croller实现控件平滑移动
 */
public class ScrollerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);
        CustomScrollView scrollView = findViewById(R.id.scrollerView);
        scrollView.smoothScrollTo(-400, 0);

    }
}

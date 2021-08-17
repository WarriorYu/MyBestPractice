package com.example.mybestpractice.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybestpractice.R;
import com.yu.common.executor.HiExecutor;

/**
 * @author : yuxibing
 * @date : 2020-09-15
 * Describe : 自定义控件练习
 */
public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        findViewById(R.id.square_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomViewActivity.this, SquareImgActivity.class));
            }
        });
        findViewById(R.id.cirecle_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomViewActivity.this, CircleViewActivity.class));

            }
        });
        findViewById(R.id.flowlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomViewActivity.this, FlowlayoutActivity.class));
            }
        });
        findViewById(R.id.scroller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomViewActivity.this, ScrollerActivity.class));
            }
        });


    }
}

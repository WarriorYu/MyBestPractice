package com.example.mybestpractice.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybestpractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

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
        ButterKnife.bind(this);
    }

    @OnClick({R.id.square_img, R.id.cirecle_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.square_img:
                startActivity(new Intent(this, SquareImgActivity.class));
                break;
            case R.id.cirecle_view:
                startActivity(new Intent(this, CircleViewActivity.class));
                break;
        }
    }
}

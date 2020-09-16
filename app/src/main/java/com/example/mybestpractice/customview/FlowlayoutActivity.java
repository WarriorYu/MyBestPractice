package com.example.mybestpractice.customview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.example.mybestpractice.R;
import com.example.mybestpractice.customview.util.ColorUtil;
import com.example.mybestpractice.customview.util.CommonUtil;
import com.example.mybestpractice.customview.util.DrawableUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowlayoutActivity extends AppCompatActivity {
    @BindView(R.id.taglayout)
    TagLayout taglayout;
    private int vPadding;
    private int hPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
        ButterKnife.bind(this);
        vPadding = CommonUtil.getDimens(R.dimen.dp6);
        hPadding = CommonUtil.getDimens(R.dimen.dp9);


        //给tagLayout添加对应的子View
        for (int i = 0; i < 30; i++) {
            final TextView textView = new TextView(this);
            textView.setTextSize(16);
            textView.setGravity(Gravity.CENTER);
            if (i % 2 == 0) {
                textView.setText("我爱中国");
            } else {
                textView.setText("走起");
            }
            textView.setTextColor(Color.WHITE);
            textView.setPadding(hPadding, vPadding, hPadding, vPadding);

            Drawable pressed = DrawableUtil.generateDrawable(ColorUtil.randomColor(), hPadding);
            Drawable normal = DrawableUtil.generateDrawable(ColorUtil.randomColor(), hPadding);
            textView.setBackgroundDrawable(DrawableUtil.generateSelector(pressed, normal));

            taglayout.addView(textView);

            //设置点击事件
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShort(textView.getText().toString());
                }
            });
        }
    }


}

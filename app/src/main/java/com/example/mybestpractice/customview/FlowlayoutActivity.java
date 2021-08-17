package com.example.mybestpractice.customview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.example.mybestpractice.R;
import com.example.mybestpractice.customview.util.ColorUtil;
import com.example.mybestpractice.customview.util.CommonUtil;
import com.example.mybestpractice.customview.util.DrawableUtil;

import java.util.ArrayList;

public class FlowlayoutActivity extends AppCompatActivity {
    TagLayout taglayout;
    private int vPadding;
    private int hPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
        taglayout = findViewById(R.id.taglayout);
        vPadding = CommonUtil.getDimens(R.dimen.dp6);
        hPadding = CommonUtil.getDimens(R.dimen.dp9);
        ArrayList<String> list = new ArrayList<>();
        list.add("显示");
        // 置不同的 Typeface 就可以显示不同的字体。我们中国人谈到「字体」，比较熟悉的词是 font， typeface 和 font 是一个意思，都表示字体
        list.add("Typeface");
        list.add("就可以显示不同的字体");
        list.add("我们中国");
        list.add("人谈到");
        list.add("字体");
        list.add("比较熟悉");
        list.add("font");
        list.add("是一个意思");
        list.add("都表示字体");
        list.add("我爱中国");
        list.add("走起");
        list.add("商品");
        list.add("商");
        list.add("一");
        list.add("二");
        list.add("三");
        list.add("雨伞");
        list.add("下雨");
        list.add("不同的字体");
        list.add("字体");

        //给tagLayout添加对应的子View
        for (int i = 0; i < list.size(); i++) {
            final TextView textView = new TextView(this);
            textView.setTextSize(16);
            textView.setGravity(Gravity.CENTER);
//            if (i % 2 == 0) {
//                textView.setText("我爱中国");
//            } else {
//                textView.setText("走起");
//            }
            textView.setText(list.get(i));
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

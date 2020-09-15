package com.example.mybestpractice.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.mybestpractice.R;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.TreeMap;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        bitmap.getAllocationByteCount();
        bitmap.getByteCount();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        TextView view = new TextView(this);
        view.requestLayout();
//        view.setLayoutParams();
        TextView textView = new TextView(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        EventBus.getDefault().register(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}

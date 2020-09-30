package com.example.mybestpractice.optimize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mybestpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OptimizeActivity extends AppCompatActivity implements ICallBack{
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimize);
        ButterKnife.bind(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        img.setImageBitmap(bitmap);
        CallBackManager.addCallBack(this);


    }

    @Override
    public void doOperate() {

    }
}

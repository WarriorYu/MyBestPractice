package com.example.mybestpractice.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import org.w3c.dom.Text;

/**
 * @author :   yuxibing
 * @date :   2020-09-16
 * Describe :
 */
public class CustomTextview extends AppCompatTextView {
    public CustomTextview(Context context) {
        super(context);
    }

    public CustomTextview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

}

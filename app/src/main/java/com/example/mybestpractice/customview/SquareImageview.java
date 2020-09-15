package com.example.mybestpractice.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author :   yuxibing
 * @date :   2020-09-15
 * Describe :
 */
public class SquareImageview extends AppCompatImageView {
    public SquareImageview(Context context) {
        this(context, null);
    }

    public SquareImageview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareImageview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 1. 通过父view 测量后
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 2. 就可以通过getMeasuredWidth()获取宽高了。
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int size = Math.min(width, height);
        // 3. 将自己想要的宽高保存，否则父view不知道，没法正常显示。
        setMeasuredDimension(size, size);
    }
}

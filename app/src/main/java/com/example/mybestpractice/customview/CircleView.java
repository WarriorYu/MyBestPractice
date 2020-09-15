package com.example.mybestpractice.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.example.mybestpractice.R;

/**
 * @author :   yuxibing
 * @date :   2020-09-15
 * Describe : 自定义view，绘制一个圆，支持wrap_content 和 Padding
 */
public class CircleView extends View {

    private int mColor;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mWidth;
    private int mHeight;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.RED);
        a.recycle();
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
        // 1. 设置一个初始值
        mWidth = dp2dx(200);
        mHeight = dp2dx(200);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 2. 如果布局里有wrap_content，效果相当于match_parent,通过resolveSize，如果宽高是wrap_content，会使用设置的默认mWidth和mHeight。
        int width = resolveSize(mWidth, widthMeasureSpec);
        int height = resolveSize(mHeight, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width, height) / 2;

        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, mPaint);
    }

    private int dp2dx(float dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5f);
    }
}

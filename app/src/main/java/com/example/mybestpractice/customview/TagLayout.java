package com.example.mybestpractice.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SizeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :   yuxibing
 * @date :   2020-09-16
 * Describe :
 */
public class TagLayout extends ViewGroup {
    private static final int HORIZONTAL_SPACE = SizeUtils.dp2px(15f);
    private static final int VERTICAL_SPACE = SizeUtils.dp2px(10f);
    // 保存child测量后的位置
    private List<Rect> childBounds = new ArrayList<>();

    public TagLayout(Context context) {
        this(context, null);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 宽度已经用了多少
        int widthUsed = 0;
        // 高度已经用了多少,默认加个顶部的边距
        int heightUsed = VERTICAL_SPACE;

        // 当前行的宽度已经用了多少,默认加个左边距
        int lineWidthUsed = HORIZONTAL_SPACE;
        // 当前行所有child的最大高度
        int lineMaxHeight = 0;

        int specWidMode = MeasureSpec.getMode(widthMeasureSpec);
        int specWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            // 对child测量
            // 需要重写 generateLayoutParams() 并返回 MarginLayoutParams 才能使  measureChildWithMargins()方法
            measureChildWithMargins(child, widthMeasureSpec, lineWidthUsed, heightMeasureSpec, heightUsed);
            if (lineWidthUsed + child.getMeasuredWidth() + HORIZONTAL_SPACE > specWidthSize && specWidMode != MeasureSpec.UNSPECIFIED) {
                // 如果加上这个child的宽度后，一行放不开，则换行,并且把本行的高度加到总高度里
                heightUsed += lineMaxHeight;
                heightUsed += VERTICAL_SPACE;

                // 换行后，本行宽度初始化为0,如果需要左边距，则为HORIZONTAL_PADDING
                lineWidthUsed = HORIZONTAL_SPACE;
                lineMaxHeight = 0;
                // 根据更新的已使用宽度和高度再次测量child
                measureChildWithMargins(child, widthMeasureSpec, lineWidthUsed, heightMeasureSpec, heightUsed);
            }

            Rect childBound;
            if (childBounds.size() <= i) {
                // 如果该child还没有创建Rect，则新建
                childBound = new Rect();
            } else {
                childBound = childBounds.get(i);
            }

            childBound.set(lineWidthUsed, heightUsed, lineWidthUsed + child.getMeasuredWidth(), heightUsed + child.getMeasuredHeight());
            childBounds.add(childBound);
            // 更新本行使用的宽度
            lineWidthUsed += child.getMeasuredWidth();
            lineWidthUsed += HORIZONTAL_SPACE;
            // 更新使用的最大宽度
            widthUsed = Math.max(widthUsed, lineWidthUsed);
            // 更新本行的最大高度
            lineMaxHeight = Math.max(lineMaxHeight, child.getMeasuredHeight());
        }
        // 最后将最后一行的高度加上
        heightUsed += lineMaxHeight;
        heightUsed += VERTICAL_SPACE;
        setMeasuredDimension(widthUsed, heightUsed);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Rect childBound = childBounds.get(i);
            child.layout(childBound.left, childBound.top, childBound.right, childBound.bottom);
        }
    }

    /**
     * 重写以支持 measureChildWithMargins 方法
     * 必须重写此方法，否则通过xml添加子View的时候报错
     *
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    /**
     * 重写以支持 measureChildWithMargins 方法
     * 必须重写此方法，否则通过addView()方式添加子View的时候报错
     *
     * @return
     */
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
}

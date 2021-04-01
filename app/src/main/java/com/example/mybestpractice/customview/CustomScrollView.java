package com.example.mybestpractice.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @author :   yuxibing
 * @date :   2021-03-29
 * Describe :
 */
public class CustomScrollView extends View {

    private Scroller mScroller;

    public CustomScrollView(Context context) {
        this(context,null);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }
}

package com.techdew.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;

public class CustomSeekBar extends android.support.v7.widget.AppCompatSeekBar {
    int base_color;
    int value_color;
    int stroke_color;
    Context context;
    private ArrayList<ProgressItem> mProgressItemsList;
    public CustomSeekBar(Context context) {
        super(context);
        this.context=context;
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomWidget);
        base_color = a.getResourceId(R.styleable.MyCustomWidget_base_color, -1);
        value_color = a.getResourceId(R.styleable.MyCustomWidget_value_color, -1);
        stroke_color= a.getResourceId(R.styleable.MyCustomWidget_stroke_color, -1);
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public void initData(int progress) {
        initDataToSeekbar((int) Math.round(progress / 10));
    }



    private void initDataToSeekbar(int val) {
        mProgressItemsList = new ArrayList<ProgressItem>();
        for(int i=0;i<10;i++){
            ProgressItem mProgressItem = new ProgressItem();
            if(i<val){
                mProgressItem.color=value_color;
            }else{
                mProgressItem.color=base_color;
            }
            mProgressItemsList.add(mProgressItem);
        }
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec,
                                          int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onDraw(Canvas canvas) {
        if (mProgressItemsList.size() > 0) {
            int progressBarWidth = getWidth();
            int progressBarHeight = getHeight();
            int lastProgressX = 0;
            int progressItemWidth, progressItemRight;
            for (int i = 0; i < mProgressItemsList.size(); i++) {
                ProgressItem progressItem = mProgressItemsList.get(i);
                Paint progressPaint = new Paint();
                progressPaint.setColor(ContextCompat.getColor(context,progressItem.color));
                progressItemWidth = (int) (10 * progressBarWidth / 100);
                progressItemRight = lastProgressX + progressItemWidth;
                Rect progressRect = new Rect();
                progressRect.set(lastProgressX, 0, progressItemRight, progressBarHeight);
                canvas.drawRect(progressRect, progressPaint);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10); // set stroke width
                paint.setColor(ContextCompat.getColor(context,stroke_color));
                canvas.drawRect(progressRect, paint);
                lastProgressX = progressItemRight;
            }
            super.onDraw(canvas);
        }
    }




}

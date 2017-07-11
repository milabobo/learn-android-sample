package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    Paint paint;

    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        setAntiAlisFlag();
    }

    void setAntiAlisFlag() {
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        int width = getWidth();
        int height = getHeight() / 2;

        int radius = height / 4 - 30;
        int startX = width / 2 - radius - 15;
        int startY = 5 + radius;

        canvas.translate(0, getHeight() / 4);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(startX, startY, radius, paint);

        paint.reset();
        setAntiAlisFlag();

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawCircle(startX + radius * 2 + 60, startY, radius, paint);

        paint.reset();
        setAntiAlisFlag();

        paint.setColor(Color.parseColor("#4A90E2"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(startX, startY + radius * 2 + 60, radius, paint);

        paint.reset();
        setAntiAlisFlag();

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(80);
        canvas.drawCircle(startX + radius * 2 + 60, startY + radius * 2 + 60, radius, paint);
    }
}

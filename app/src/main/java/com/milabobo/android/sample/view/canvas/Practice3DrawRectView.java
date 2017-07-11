package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    Paint paint;

    public Practice3DrawRectView(Context context) {
        super(context);
        init();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        setAntiAlisFlag();
    }

    void setAntiAlisFlag() {
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        int startX = getWidth() / 2;
        int startY = getHeight() / 2;
        int length = 450;
        int halfLength = length / 2;
        canvas.drawRect(startX - halfLength, startY - halfLength,
                startX + halfLength, startY + halfLength,
                paint);
    }
}

package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    Paint paint;
    Path path;
    public Practice9DrawPathView(Context context) {
        super(context);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawPath() 方法画心形
        int radius = 90;
        int leftX = getWidth() / 2 - radius * 7 / 4;
        int leftY = getHeight() / 2 +
                (int) Math.sqrt(radius * radius - radius * radius * 9 / 16);

        int rightX = getWidth() / 2 + radius * 7 / 4;
        int rightY = leftY;

        int downX = getWidth() / 2;
        double angle = Math.acos((getWidth() / 2 - leftX - radius) * 1.0f / radius);
        double halfAngle = (Math.PI - angle) / 2;

        int downY = getHeight() / 2 + (int)(radius * Math.tan(halfAngle));

        canvas.translate(0, -radius);
        canvas.drawCircle(getWidth() / 2 - radius, getHeight() / 2, radius, paint);
        canvas.drawCircle(getWidth() / 2 + radius, getHeight() / 2, radius, paint);

        if (path == null) {
            path = new Path();
        }
        path.reset();
        path.moveTo(getWidth() / 2, getHeight() / 2);
        path.lineTo(rightX, rightY);
        path.lineTo(downX, downY);
        path.lineTo(leftX, leftY);
        path.close();
        canvas.drawPath(path, paint);
    }
}

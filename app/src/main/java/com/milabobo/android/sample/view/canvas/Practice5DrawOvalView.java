package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {

    Paint paint;

    public Practice5DrawOvalView(Context context) {
        super(context);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        int startX = getWidth() / 2;
        int startY = getHeight() / 2;
        int upLength = 250;
        int hoLength = 500;
        int halfUpLength = upLength / 2;
        int halfHoLength = hoLength / 2;
        if (isOverIceCream()) {
            canvas.drawOval(startX - halfHoLength, startY - halfUpLength,
                    startX + halfHoLength, startY + halfUpLength,
                    paint);
        }
    }

    static boolean isOverIceCream() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

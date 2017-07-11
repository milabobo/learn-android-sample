package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

    Paint paint;
    public Practice7DrawRoundRectView(Context context) {
        super(context);
        init();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        int startX = getWidth() / 2;
        int startY = getHeight() / 2;
        int upLength = 230;
        int hoLength = 480;
        int halfUpLength = upLength / 2;
        int halfHoLength = hoLength / 2;
        int radius = 50;
        int yRadius = 50;
        if (isOverIceCream()) {
            canvas.drawRoundRect(startX - halfHoLength, startY - halfUpLength,
                    startX + halfHoLength, startY + halfUpLength,
                    radius, yRadius,
                    paint);
        }
    }

    static boolean isOverIceCream() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

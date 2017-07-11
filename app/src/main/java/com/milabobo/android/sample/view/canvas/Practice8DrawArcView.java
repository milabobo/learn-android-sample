package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    Paint paint;
    RectF rectF;
    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int startX = getWidth() / 2;
        int startY = getHeight() / 2;
        int upLength = 300;
        int hoLength = 450;
        int halfUpLength = upLength / 2;
        int halfHoLength = hoLength / 2;

        if (rectF == null) {
            rectF = new RectF(0,0,0,0);
        }
        rectF.set(startX - halfHoLength, startY - halfUpLength,
                startX + halfHoLength, startY + halfUpLength);

        if (isOverIceCream()) {
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawArc(rectF, -110, 100, true, paint);

            canvas.drawArc(rectF, 160, -140, false, paint);

            paint.reset();
            setAntiAlisFlag();
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(1);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawArc(rectF, -180, 60, false, paint);
        }
    }

    static boolean isOverIceCream() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

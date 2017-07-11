package com.milabobo.android.sample.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class Practice10HistogramView extends View {
    Paint paint;
    Paint linePaint;
    TextPaint textPaint;
    float titleSize;
    float histSize;
    Path axisYxis;
    RectF rectF = new RectF();

    String title = "直方图";
    int maxHist = 400;
    int strokeWidth = 2;
    HistModel[] models = new HistModel[] {
            new HistModel("Froyo", 2),
            new HistModel("GB", 14),
            new HistModel("ICS", 14),
            new HistModel("JB", 150),
            new HistModel("KitKat", 300),
            new HistModel("L", maxHist),
            new HistModel("M", 120),
    };

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        axisYxis = new Path();
        paint = new Paint();
        paint.setColor(Color.parseColor("#61AF13"));
        paint.setStyle(Paint.Style.FILL);
        textPaint = new TextPaint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        linePaint = new Paint();
        linePaint.setColor(Color.WHITE);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(strokeWidth);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        titleSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 18,
                metrics);
        histSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 12,
                metrics);
        setAntiAlisFlag();
    }

    void setAntiAlisFlag() {
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        linePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int leftPadding = 100;
        int rightPadding = 100;
        int topPadding = 20;
        int histBottomPadding = 150;
        int bottomPadding = 20;

        // draw title
        textPaint.setTextSize(titleSize);
        float titleHeight = textPaint.getFontMetrics().bottom;
        canvas.drawText(title, getWidth() / 2,
                getHeight() - bottomPadding - titleHeight / 2, textPaint);

        // draw axis
        axisYxis.reset();
        axisYxis.moveTo(leftPadding, topPadding);
        axisYxis.lineTo(leftPadding, getHeight() - bottomPadding - histBottomPadding);
        axisYxis.lineTo(getWidth() - rightPadding,
                getHeight() - bottomPadding - histBottomPadding);
        canvas.drawPath(axisYxis, linePaint);

        // draw hist
        int padding = 30;
        int gap = 20;
        int length = (getWidth() - 2 * (padding + leftPadding)
                - gap * (models.length - 1))
                / models.length;
        int sumLength = padding;
        int histMaxHeight = getHeight() - bottomPadding -
                histBottomPadding - topPadding - 40;
        float percent = histMaxHeight * 1.0f / maxHist;
        canvas.translate(leftPadding,
                getHeight() - bottomPadding - histBottomPadding - strokeWidth);
        textPaint.setTextSize(histSize);
        textPaint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i < models.length; i++) {
            float left = sumLength;
            float top = -models[i].height * percent;
            float right = sumLength + length;
            float bottom = 0;
            rectF.set(left, top, right, bottom);
            canvas.drawRect(rectF, paint);
            sumLength += length + gap;
            float height = -textPaint.getFontMetrics().ascent;
            canvas.drawText(models[i].text,
                    left + length / 2, height, textPaint);
        }
    }

    private class HistModel {
        String text;
        int height;

        HistModel(String text, int height) {
            this.text = text;
            this.height = height;
        }
    }

}

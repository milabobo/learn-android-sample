package com.milabobo.android.sample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.milabobo.android.sample.R;

/**
 * Show a view by canvas
 */
public class SimpleCanvasView extends View {
    private int color;
    private String text;
    private Drawable drawable;
    private float dim;

    private TextPaint paint;
    private float textWidth;
    private float textHeight;

    public SimpleCanvasView(Context context) {
        this(context, null);
    }

    public SimpleCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SimpleCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr, defStyleRes);
    }

    private void init(AttributeSet attributeSet, int defStyleAttr, int defStyleRes) {
        final TypedArray a = getContext().obtainStyledAttributes(attributeSet,
                R.styleable.SimpleCanvasView, defStyleAttr, defStyleRes);
        color = a.getColor(R.styleable.SimpleCanvasView_exampleColor, Color.GRAY);
        text = a.getString(R.styleable.SimpleCanvasView_exampleString);
        if (TextUtils.isEmpty(text)) {
            text = "Hello";
        }
        drawable = a.getDrawable(R.styleable.SimpleCanvasView_exampleDrawable);
        if (drawable != null) {
            drawable.setCallback(this);
        }
        dim = a.getDimensionPixelOffset(R.styleable.SimpleCanvasView_exampleDimension, 11);
        a.recycle();

        paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextAlign(Paint.Align.LEFT);

        measureText();
    }

    private void measureText() {
        paint.setTextSize(dim);
        paint.setColor(color);
        textWidth = paint.measureText(text);
        textHeight = paint.getFontMetrics().bottom;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = getPaddingLeft();
        int right = getPaddingRight();
        int top = getPaddingTop();
        int bottom = getPaddingBottom();
        if (drawable != null) {
            drawable.setBounds(left, top, getWidth() - right, getHeight() - bottom);
            drawable.draw(canvas);
        }

        canvas.drawText(text,
                left + (getWidth() - textWidth) / 2,
                top + (getHeight() - textHeight) / 2, paint);

    }
}

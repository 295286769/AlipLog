package com.srx.huangshang.rentalcar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.srx.huangshang.R;

/**
 * Created by huangweishui on 2018/4/16.
 */

public class MyView extends View {
    Paint drawText;
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        drawText=new Paint();
        drawText.setAntiAlias(true);
        drawText.setColor(getResources().getColor(R.color.colorAccent));
        drawText.setTextSize(getResources().getDimension(R.dimen.button_text_size));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("helloword",0f,0f,drawText);
    }
}

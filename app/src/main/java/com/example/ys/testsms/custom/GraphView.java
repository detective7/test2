package com.example.ys.testsms.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Describe:
 * Created by ys on 2016/10/12 16:09.
 */

public class GraphView extends View {

    private int height,width;
    private Paint linePaint;

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    private void initLine(Canvas canvas) {
        linePaint =new Paint();
        linePaint.setStrokeWidth(3);
        linePaint.setColor(Color.BLACK);

        canvas.drawLine(0,height/2,width,height/2,linePaint);
        canvas.drawLine(width/2,0,width/2,height,linePaint);

        canvas.save();
        canvas.translate(width/2,height/2);
        linePaint.setStrokeWidth(1);
        Log.e("abc",width+"   "+height);
        //画竖线
        for(int i=1;i<=width/260;i++){
            linePaint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(130*i,-height/2,130*i,height/2,linePaint);
            canvas.drawLine(-130*i,-height/2,-130*i,height/2,linePaint);
            linePaint.setStyle(Paint.Style.FILL);
            linePaint.setTextSize(40);
            canvas.drawText(5*i+"",130*i-(5*i+"").length()*10,40,linePaint);
            canvas.drawText(-5*i+"",-130*i-((5*i+"").length()+0.5f)*10,40,linePaint);
        }
        //画横线
        for(int i=1;i<=height/260;i++){
            linePaint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(-width/2,130*i,width/2,130*i,linePaint);
            canvas.drawLine(-width/2,-130*i,width/2,-130*i,linePaint);
            linePaint.setStyle(Paint.Style.FILL);
            linePaint.setTextSize(40);
            canvas.drawText(5*i+"",0,130*i+(5*i+"").length()*10,linePaint);
            canvas.drawText(-5*i+"",0,-130*i+(5*i+"").length()*10,linePaint);
        }

        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initLine(canvas);
    }
}

package com.example.ys.testsms.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ys.testsms.DpSpUtil;
import com.example.ys.testsms.R;

/**
 * Describe:
 * Created by ys on 2016/10/10 10:25.
 */

public class TitleBarView extends RelativeLayout {

    private Button leftBtn,rightBtn;
    private TextView title;
    private Drawable leftBtnBg,rightBtnBg;
    private LayoutParams leftParams,titleParams,RightParams;
    private int leftBtnTextSize,centerTitleSize,RightBtnTextSize;
    private int leftBtnTextColor,centerTitleColor,RightBtnTextColor;
    private int isLeftBtn,isCenterTitle,isRightBtn;
    private String leftBtnText,centerTitleText,RightBtnText;
    private Paint mPaint;

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        obtainStyledAttrs(attrs); //获取自定义的属性
    }

    private void obtainStyledAttrs(AttributeSet attrs) {
        TypedArray arr = null;
        arr = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBarView);
        isLeftBtn = arr.getInt(R.styleable.TitleBarView_isLeftBtn,0);
        isCenterTitle = arr.getInt(R.styleable.TitleBarView_isCenterTitle,0);

        if(isLeftBtn==1){
            leftBtnBg = arr.getDrawable(R.styleable.TitleBarView_leftBtnBg);
            leftBtn = new Button(getContext());
            leftBtn.setBackground(leftBtnBg);

            leftParams = new RelativeLayout.LayoutParams(60, ViewGroup.LayoutParams.MATCH_PARENT);
            leftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
            leftParams.setMargins(32,23,0,23);
            addView(leftBtn, leftParams);
        }
        if(isLeftBtn==2){
            leftBtnText = arr.getString(R.styleable.TitleBarView_leftBtnText);
            leftBtnTextSize = arr.getInt(R.styleable.TitleBarView_leftBtnTextSize,16);
            leftBtnTextColor = arr.getColor(R.styleable.TitleBarView_leftBtnTextColor,getResources().getColor(R.color.white));
            leftBtn = new Button(getContext());
            leftBtn.setText(leftBtnText);
            leftBtn.setTextColor(leftBtnTextColor);
            leftBtn.setTextSize(leftBtnTextSize);
            leftBtn.setBackgroundColor(getResources().getColor(R.color.nothing));
            leftBtn.setPadding(0,0,0,0);
            mPaint.setTextSize(leftBtnTextSize);
            Rect textBound = new Rect();
            mPaint.getTextBounds(leftBtnText, 0, leftBtnText.length(), textBound);
            Log.e("abc",leftBtnText.length()+"   "+textBound.right+"   "+textBound.left+"   "+DpSpUtil.dp2px(getContext(),textBound.right-textBound.left));
            leftParams = new RelativeLayout.LayoutParams(DpSpUtil.sp2px(getContext(),leftBtnTextSize*leftBtnText.length()), ViewGroup.LayoutParams.WRAP_CONTENT);
            leftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
            leftParams.setMargins(32,23,0,23);
            addView(leftBtn, leftParams);
        }

        if(isCenterTitle==1){

        }

    }

    public TitleBarView(Context context) {
        super(context);
    }

}

package com.example.administrator.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.chat.R;

/**
 * Created by Administrator on 2017/6/12.
 */

public class PicAndTextBtn extends LinearLayout {
    private Context context;

    private ImageView imageView;
    private TextView textView;

    private Drawable image;
    private Drawable imageBackground;

    private String text;
    private float textSize;
    private int textColor;
    private Drawable textBackground;

    private picAndTextBtnClickListener listener;

    public PicAndTextBtn(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        findAttrs(attrs);
        initViews();
        setPicAndTextBtnParams();
        setClickListener();
    }

    public interface picAndTextBtnClickListener{
        void onClick();
    }

    public void setOnClickListener(picAndTextBtnClickListener listener){
        this.listener = listener;
    }

    public void setImageView (int id){
        imageView.setImageResource(id);
    }

    private void setClickListener() {
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });
    }

    private void setPicAndTextBtnParams() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(20,0,0,0);

        LayoutParams imageLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(imageView,imageLayoutParams);

        LayoutParams textViewLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(textView,textViewLayoutParams);
    }

    private void initViews() {
        imageView = new ImageView(context);
        textView = new TextView(context);

        imageView.setImageDrawable(image);
        imageView.setBackground(imageBackground);

        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setBackground(textBackground);

        textView.setGravity(Gravity.END);
    }

    private void findAttrs(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.PicAndTextBtn);

        image = typedArray.getDrawable(R.styleable.PicAndTextBtn_pic);
        imageBackground = typedArray.getDrawable(R.styleable.PicAndTextBtn_picBackground);

        text = typedArray.getString(R.styleable.PicAndTextBtn_text);
        textSize = typedArray.getDimension(R.styleable.PicAndTextBtn_textSize,0);
        textColor = typedArray.getColor(R.styleable.PicAndTextBtn_textColor,0);
        textBackground = typedArray.getDrawable(R.styleable.PicAndTextBtn_textBackground);

        typedArray.recycle();
    }
}

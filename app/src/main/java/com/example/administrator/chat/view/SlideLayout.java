package com.example.administrator.chat.view;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.administrator.chat.DressUpActivity;
import com.example.administrator.chat.ProfileActivity;
import com.example.administrator.chat.R;
import com.example.administrator.chat.SettingActivity;

public class SlideLayout extends FrameLayout {

    private static final String TAG = "SlideLayout";

    private PicAndTextBtn dressUp;
    private PicAndTextBtn profile;
    private PicAndTextBtn setting;
    private PicAndTextBtn night;

    private Context context;
    private boolean nightMode = false;

    public SlideLayout(@NonNull Context context) {
        super(context);
        this.context = context;
        initViews();
    }

    public SlideLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public SlideLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews(){
        this.addView(LayoutInflater.from(context).inflate(R.layout.layout_slide,null));
        dressUp = (PicAndTextBtn) findViewById(R.id.patb_dressup);
        profile = (PicAndTextBtn) findViewById(R.id.patb_profile);
        setting = (PicAndTextBtn) findViewById(R.id.patb_setting);
        night = (PicAndTextBtn) findViewById(R.id.patb_night);

        dressUp.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick() {
                Intent intent = DressUpActivity.newIntent(context);
                context.startActivity(intent);
            }
        });

        profile.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick() {
                Intent intent = ProfileActivity.newIntent(context);
                context.startActivity(intent);
            }
        });

        setting.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick() {
                Intent intent = SettingActivity.newIntent(context);
                context.startActivity(intent);
            }
        });

        night.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick() {
                if (nightMode){
                    findViewById(R.id.layout_slide).setBackgroundColor(0xff878787);
                    nightMode = false;
                } else {
                    findViewById(R.id.layout_slide).setBackgroundColor(0xffe9e9e9);
                    nightMode = true;
                }
            }
        });
    }
}

package com.example.administrator.chat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.administrator.chat.view.TitleBar;


public class SettingActivity extends AppCompatActivity {

    private static final String CHAT = "chat";
    public static final String GUIDE = "guide";
    private static final String PASSWORD_MODE = "password";
    private static final String OFFLINE_MODE = "offline";
    private Switch guide;
    private boolean guideMode;
    private Switch password;
    private boolean passwordMode;
    private ImageView offline;
    private boolean offlineMode = false;
    private TitleBar titleBar;

    public static Intent newIntent(Context context){
        return new Intent(context,SettingActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);

        initViews();
    }

    private void initViews() {
        titleBar = (TitleBar) findViewById(R.id.tab_setting);
        guide = (Switch) findViewById(R.id.setting_guide);
        password = (Switch) findViewById(R.id.remember_password);
        offline = (ImageView) findViewById(R.id.iv_offline);

        guideMode = getSharedPreferences(CHAT,MODE_PRIVATE).getBoolean(GUIDE,true);
        passwordMode = getSharedPreferences(CHAT,MODE_PRIVATE).getBoolean(PASSWORD_MODE,true);
        offlineMode = getSharedPreferences(CHAT,MODE_PRIVATE).getBoolean(OFFLINE_MODE,false);

        //初始化控件状态
        guide.setChecked(guideMode);
        password.setChecked(passwordMode);
        offline.setImageResource(offlineMode ? R.drawable.btnselected : R.drawable.btnunselected);

        guide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                guideMode = isChecked;
            }
        });

        password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                passwordMode = isChecked;
            }
        });

        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (offlineMode){
                    offline.setImageResource(R.drawable.btnunselected);
                    offlineMode = false;
                } else {
                    offline.setImageResource(R.drawable.btnselected);
                    offlineMode = true;
                }
            }
        });

        titleBar.setTitleBarClickListener(new TitleBar.titleBarClickListener() {
            @Override
            public void leftButtonClick() {
                finish();
            }

            @Override
            public void rightButtonClick() {
                SharedPreferences sharedPreferences = getSharedPreferences(CHAT,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(GUIDE,guideMode);
                editor.putBoolean(PASSWORD_MODE,passwordMode);
                editor.putBoolean(OFFLINE_MODE,offlineMode);
                editor.apply();
                finish();
            }
        });
    }
}

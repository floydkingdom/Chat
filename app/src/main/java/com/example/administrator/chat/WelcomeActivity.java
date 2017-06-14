package com.example.administrator.chat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class WelcomeActivity extends AppCompatActivity {

    private static final int DELAY = 2000;
    private static final int GO_GUIDE = 0;
    private static final int GO_HOME = 1;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUIDE:
                    goGuide();
                    break;
                case GO_HOME:
                    goHome();
                    break;
                default:
                    break;
            }
        }
    };

    private void goHome() {
        Intent intent = new Intent(this, LoginOrRegisterActivity.class);
        startActivity(intent);
        finish();
    }

    private void goGuide() {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        initLoad();
    }

    private void initLoad() {
        SharedPreferences sharedPreferences = getSharedPreferences("chat", MODE_PRIVATE);
        boolean welcome = sharedPreferences.getBoolean("welcome", true);
        boolean guide = sharedPreferences.getBoolean(SettingActivity.GUIDE,false);
        if (!welcome && !guide) {       //首次启动程序过后，welcome一直为false，所以，之后是否启动引导页取决于guide
            handler.sendEmptyMessageDelayed(GO_HOME, DELAY);
        } else {
            handler.sendEmptyMessageDelayed(GO_GUIDE, DELAY);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("welcome", false);
            editor.apply();
        }
    }
}

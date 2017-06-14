package com.example.administrator.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/8.
 */

public class LoginOrRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TabHost tabHost;
    private Button btnLogin,btnRegister;
    private EditText etLoginUsername,etLoginPassword,etRegisterUsername,etRegisterPassword,etEnsurePassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);

        initViews();
    }

    private void initViews() {
        tabHost = (TabHost) findViewById(R.id.tab_host);

        btnLogin = (Button) findViewById(R.id.btn_login);
        etLoginUsername = (EditText) findViewById(R.id.et_login_username);
        etLoginPassword = (EditText) findViewById(R.id.et_login_password);

        btnRegister = (Button) findViewById(R.id.btn_register);
        etRegisterUsername = (EditText) findViewById(R.id.et_register_username);
        etRegisterPassword = (EditText) findViewById(R.id.et_register_password);
        etEnsurePassword = (EditText) findViewById(R.id.et_ensure_password);

        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("Login").setIndicator("Login").setContent(R.id.layout_login));
        tabHost.addTab(tabHost.newTabSpec("Register").setIndicator("Register").setContent(R.id.layout_register));
        TabWidget tabWidget = tabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getTabCount(); i++){
            TextView textView = (TextView) tabWidget.getChildTabViewAt(i).findViewById(android.R.id.title);     //获取tab中控件的实例
//            textView.setTransformationMethod(null);           //不设置大小写
            textView.setAllCaps(false);
            textView.setTextSize(20);
        }

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_register:
                break;
            default:
                break;
        }
    }
}

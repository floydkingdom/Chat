package com.example.administrator.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.chat.view.TitleBar;

public class ProfileActivity extends AppCompatActivity {

    private TitleBar tbProfile;
    private EditText etUsername;
    private EditText etSign;
    private EditText etPassword;
    private EditText etInsurePassword;

    public static Intent newIntent(Context context){
        return new Intent(context,ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
    }

    private void initViews() {
        tbProfile = (TitleBar) findViewById(R.id.tab_profile);
        etUsername = (EditText) findViewById(R.id.et_profile_username);
        etSign = (EditText) findViewById(R.id.et_profile_sign);
        etPassword = (EditText) findViewById(R.id.et_profile_password);
        etInsurePassword = (EditText) findViewById(R.id.et_profile_insure_password);

        tbProfile.setTitleBarClickListener(new TitleBar.titleBarClickListener() {
            @Override
            public void leftButtonClick() {
                finish();
            }

            @Override
            public void rightButtonClick() {
                Toast.makeText(ProfileActivity.this,"Submit Success!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}

package com.example.administrator.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.chat.utils.ImageManager;
import com.example.administrator.chat.utils.ImageMsg;
import com.example.administrator.chat.view.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class DressUpActivity extends AppCompatActivity {

    private TitleBar tbDressUp;
    private RecyclerView rvAvatar;
    private RecyclerView rvBackground;

    public static Intent newIntent(Context context){
        return new Intent(context,DressUpActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_up);
        
        initViews();
    }

    private void initViews() {
        tbDressUp = (TitleBar) findViewById(R.id.tb_dress_up);
        rvAvatar = (RecyclerView) findViewById(R.id.rv_dress_up_avatar);
        rvBackground = (RecyclerView) findViewById(R.id.rv_dress_up_background);
        
        addAvatarView();
        addBackgroundView();

        tbDressUp.setTitleBarClickListener(new TitleBar.titleBarClickListener() {
            @Override
            public void leftButtonClick() {
                finish();
            }

            @Override
            public void rightButtonClick() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(DressUpActivity.this,"Saved!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void addBackgroundView() {
    }

    private void addAvatarView() {
        List<ImageMsg> imageMsgs = new ArrayList<>();
        for (int anImageAvatar : ImageManager.imageAvatar){
            ImageMsg imageMsg = new ImageMsg();
            imageMsg.setImageId(anImageAvatar);
            imageMsgs.add(imageMsg);
        }


    }
}

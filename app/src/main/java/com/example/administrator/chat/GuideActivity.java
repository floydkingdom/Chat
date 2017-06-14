package com.example.administrator.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.chat.adapter.AdapterGuideViewPager;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private List<View> viewList;
    private ImageView imageViews[] = new ImageView[3];
    private Button btnToMain;
    private int[] indicatorDotIds = {R.id.iv_indicator_dot1, R.id.iv_indicator_dot2, R.id.iv_indicator_dot3};
    private ViewPager viewPager;
    private AdapterGuideViewPager adapterGuideViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //选择的主题风格没有ActionBar
//        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        initViews();
    }

    private void initViews() {
        //load view
        LayoutInflater inflater = LayoutInflater.from(this);

        viewList = new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_page_1, null));
        viewList.add(inflater.inflate(R.layout.guide_page_2, null));
        viewList.add(inflater.inflate(R.layout.guide_page_3, null));

        //bind id with imageView
        for (int i = 0; i <indicatorDotIds.length; i++){
            imageViews[i] = (ImageView) findViewById(indicatorDotIds[i]);
        }

        adapterGuideViewPager = new AdapterGuideViewPager(this,viewList);

        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(adapterGuideViewPager);
        viewPager.addOnPageChangeListener(this);

        //从viewList中找到对应的view，再从view中根据id找到button
        btnToMain = (Button)(viewList.get(2)).findViewById(R.id.btn_to_main);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this,LoginOrRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < indicatorDotIds.length; i++){
            if (i != position){
                imageViews[i].setImageResource(R.drawable.unselected);
            } else {
                imageViews[i].setImageResource(R.drawable.selected);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

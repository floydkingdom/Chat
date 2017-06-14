package com.example.administrator.chat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.chat.adapter.AdapterViewpager;
import com.example.administrator.chat.fragment.ChatsFragment;
import com.example.administrator.chat.fragment.ContactsFragment;
import com.example.administrator.chat.fragment.MomentsFragment;
import com.example.administrator.chat.utils.ImageManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<TabLayout.Tab> tabList;
    private AdapterViewpager adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.view_pager_main);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_main);
        tabList = new ArrayList<>();

        adapterViewPager = new AdapterViewpager(getSupportFragmentManager());
        adapterViewPager.addFragment(new ChatsFragment());
        adapterViewPager.addFragment(new ContactsFragment());
        adapterViewPager.addFragment(new MomentsFragment());

        viewPager.setAdapter(adapterViewPager);

        tabLayout.setupWithViewPager(viewPager);
        tabList.add(tabLayout.getTabAt(0));
        tabList.add(tabLayout.getTabAt(1));
        tabList.add(tabLayout.getTabAt(2));
        tabList.get(0).setIcon(R.drawable.msgselected).setText("Chats");
        tabList.get(1).setIcon(R.drawable.contactsunselected).setText("Contacts");
        tabList.get(2).setIcon(R.drawable.momentunselected).setText("Moments");
        tabLayout.setTabTextColors(ContextCompat.getColor(MainActivity.this, R.color.colorBlack),
                ContextCompat.getColor(MainActivity.this, R.color.colorBlue));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabList.get(tab.getPosition()).setIcon(ImageManager.imageID[tab.getPosition() + 3]);
//                tabLayout.setTabTextColors(R.color.colorBlue, R.color.colorBlack);      错误     //设置tab选中与为选中的字体颜色
                tabLayout.setTabTextColors(ContextCompat.getColor(MainActivity.this, R.color.colorBlack),
                        ContextCompat.getColor(MainActivity.this, R.color.colorBlue));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabList.get(tab.getPosition()).setIcon(ImageManager.imageID[tab.getPosition()]);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

}

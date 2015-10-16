package com.gobelinscrm14.noemiediaz.backstage.chat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.gobelinscrm14.noemiediaz.backstage.R;
import com.gobelinscrm14.noemiediaz.backstage.chat.adapter.FragmentAdapter;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "chatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),
                ChatActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }



}

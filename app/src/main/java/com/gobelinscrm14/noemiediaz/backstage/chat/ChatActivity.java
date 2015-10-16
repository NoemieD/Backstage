package com.gobelinscrm14.noemiediaz.backstage.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.gobelinscrm14.noemiediaz.backstage.R;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "chatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

       getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContent, new ChatListFragment())
                .commit();


    }



}

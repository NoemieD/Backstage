package com.gobelinscrm14.noemiediaz.backstage.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gobelinscrm14.noemiediaz.backstage.R;
import com.gobelinscrm14.noemiediaz.backstage.chat.user.UserProfilFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.InitialHomeFragment;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "chatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //ADD TOOLBAR
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContent, new UserProfilFragment())
                .commit();

    }


}

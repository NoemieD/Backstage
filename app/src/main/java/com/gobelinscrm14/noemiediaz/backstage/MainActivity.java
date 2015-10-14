package com.gobelinscrm14.noemiediaz.backstage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gobelinscrm14.noemiediaz.backstage.home.InitialHomeFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ADD INITIAL FRAGMENT ON MAIN ACTIVITY TO CREATE THE HOMEPAGE
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContent, new InitialHomeFragment())
                .commit();
    }
}

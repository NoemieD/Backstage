package com.gobelinscrm14.noemiediaz.backstage;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gobelinscrm14.noemiediaz.backstage.home.InitialHomeFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.user.LoginFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.user.RegisterFragment;

public class MainActivity extends AppCompatActivity implements InitialHomeFragment.InitialHomeListener{

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

    @Override
    public void onRegisterClicked() {
        //ADD REGISTER FRAGMENT AFTER CLICK
        getSupportFragmentManager()
                .beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.mainContent, new RegisterFragment())
                .commit();
    }

    @Override
    public void onLoginClicked() {
        //ADD LOG FRAGMENT AFTER CLICK
        getSupportFragmentManager()
                .beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.mainContent, new LoginFragment())
                .commit();
    }
}

package com.gobelinscrm14.noemiediaz.backstage;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.FirebaseError;
import com.gobelinscrm14.noemiediaz.backstage.home.InitialHomeFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.user.LoginFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.user.RegisterFragment;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements InitialHomeFragment.InitialHomeListener, RegisterFragment.RegisterListener,Authentification.FirebaseListener{

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
    public void onRegisterChoiceClicked() {
        Log.d(TAG, "on register clicked");
        //ADD REGISTER FRAGMENT AFTER CLICK
        getSupportFragmentManager()
                .beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.mainContent, new RegisterFragment())
                .commit();
    }

    @Override
    public void onLoginChoiceClick() {
        Log.d(TAG, "on login clicked");
        //ADD LOG FRAGMENT AFTER CLICK
        getSupportFragmentManager()
                .beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.mainContent, new LoginFragment())
                .commit();
    }

    @Override
    public void onRegisterClicked(CharSequence loginEmail, CharSequence passwordName) {
        Log.d(TAG, loginEmail.toString() + " - " + passwordName.toString());
        Authentification.getInstance().createUser(loginEmail.toString(), passwordName.toString(), this);
    }

    @Override
    public void onSucessRegister(Map<String, Object> stringObjectMap) {
        Log.d(TAG, "on sucess register");
        getSupportFragmentManager()
                .beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.mainContent, new LoginFragment())
                .commit();
    }

    @Override
    public void onError(FirebaseError firebaseError) {
        Log.d(TAG, "on error register");
    }
}

package com.gobelinscrm14.noemiediaz.backstage;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firebase.client.AuthData;
import com.firebase.client.FirebaseError;
import com.gobelinscrm14.noemiediaz.backstage.home.InitialHomeFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.user.LoginFragment;
import com.gobelinscrm14.noemiediaz.backstage.home.user.RegisterFragment;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements InitialHomeFragment.InitialHomeListener, RegisterFragment.RegisterListener, LoginFragment.LoginListener,Authentification.FirebaseListener{

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
    public void onRegisterClicked(CharSequence registerEmail, CharSequence registerPassword) {
        Log.d(TAG, registerEmail.toString() + " - " + registerPassword.toString());
        Authentification.getInstance().createUser(registerEmail.toString(), registerPassword.toString(), this);
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

    @Override
    public void onSucessAuthenticated(AuthData authData) {
        Log.d(TAG, "on success authenticated");
    }

    @Override
    public void onErrorAuthentification(FirebaseError firebaseError) {
        Snackbar.make(findViewById(R.id.mainContent), "It's not good !", Snackbar.LENGTH_LONG)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "Close");
                    }
                })
                .show();
    }

    @Override
    public void onLoginClicked(CharSequence loginEmail, CharSequence loginPassword) {
        Log.d(TAG, loginEmail.toString() + " - " + loginPassword.toString());
        Authentification.getInstance().authenticate(loginEmail.toString(), loginPassword.toString(), this);

    }
}

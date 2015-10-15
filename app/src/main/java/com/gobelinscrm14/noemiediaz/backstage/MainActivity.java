package com.gobelinscrm14.noemiediaz.backstage;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.gobelinscrm14.noemiediaz.backstage.chat.ChatActivity;
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

        //ADD TOOLBAR
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        //ADD INITIAL FRAGMENT ON MAIN ACTIVITY TO CREATE THE HOMEPAGE
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainContent, new InitialHomeFragment())
                .commit();
    }

    //CREATE MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //OPTION MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuMainHomeItem) {
            //Home Clicked
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, new InitialHomeFragment())
                    .commit();

            return true;
        } else if (item.getItemId() == R.id.menuMainLoginItem) {
            // Login Clicked
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, new LoginFragment())
                    .commit();
            return true;
        }
        else if (item.getItemId() == R.id.menuMainRegisterItem) {
            //Register Clicked
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, new RegisterFragment())
                    .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    public void onRegisterClicked(User user) {
        Log.d(TAG, user.getEmail() + "-" + user.getPseudo() + "-" + user.getPassword());
        Authentification.getInstance().createUser(user.getPseudo(), user.getEmail(), user.getPassword(), this);
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
        Intent intent = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intent);
        finish();
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

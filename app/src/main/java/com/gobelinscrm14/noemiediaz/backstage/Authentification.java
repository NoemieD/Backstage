package com.gobelinscrm14.noemiediaz.backstage;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.gobelinscrm14.noemiediaz.backstage.home.user.User;

import java.util.Map;

public class Authentification {

    private User user;
    private Firebase myFirebaseRef;

    private static Authentification ourInstance = new Authentification();

    public static Authentification getInstance() {

        return ourInstance;
    }

    private Authentification() {
        myFirebaseRef = new Firebase("https://backstagecrm14.firebaseio.com/");
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createUser(String email, String password, final FirebaseListener listener){

        myFirebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                listener.onSucessRegister(stringObjectMap);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                listener.onError(firebaseError);
            }
        });
    }

    public void authenticate(String email, String password, final FirebaseListener listener){

        myFirebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {

                user = new User();
                user.setEmail(authData.getProviderData().get("email").toString());
                listener.onSucessAuthenticated(authData);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                listener.onErrorAuthentification(firebaseError);
            }
        });
    }

    public interface FirebaseListener {
        void onSucessRegister(Map<String, Object>  stringObjectMap);
        void onError(FirebaseError firebaseError);
        void onSucessAuthenticated(AuthData authData);
        void onErrorAuthentification(FirebaseError firebaseError);
    }


}
package com.gobelinscrm14.noemiediaz.backstage;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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

    public void createUser(String pseudo, String email, String password, final FirebaseListener listener){

        user = new User(pseudo,email,password);

        myFirebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                pushUserInFirebase(stringObjectMap.get("uid").toString());
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
                getUserByUid(authData.getUid(), listener);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                listener.onErrorAuthentification(firebaseError);
            }
        });
    }

    public void getUserByUid(String uid, final FirebaseListener listener) {

        Firebase userRef = myFirebaseRef.child("users").child(uid);

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                setUser(snapshot.getValue(User.class));
                listener.onSucessAuthenticated();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    public void pushUserInFirebase(String uid){
        Firebase userRef = myFirebaseRef.child("users").child(uid);
        userRef.setValue(getUser());
    }

    public interface FirebaseListener {
        void onSucessRegister(Map<String, Object>  stringObjectMap);
        void onError(FirebaseError firebaseError);
        void onSucessAuthenticated();
        void onErrorAuthentification(FirebaseError firebaseError);
    }


}

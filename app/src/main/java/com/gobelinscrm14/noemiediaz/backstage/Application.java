package com.gobelinscrm14.noemiediaz.backstage;

import com.firebase.client.Firebase;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}

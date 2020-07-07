package com.example.override_fivemonthn;

import android.app.Application;


import com.example.override_fivemonthn.data.BoredApiClient;

public class App extends Application {

    public static BoredApiClient boredApiClient;
    @Override

    public void onCreate() {
        super.onCreate();




    boredApiClient=new  BoredApiClient();
}




    }







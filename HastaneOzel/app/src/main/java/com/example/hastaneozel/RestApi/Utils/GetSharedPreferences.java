package com.example.hastaneozel.RestApi.Utils;

import android.app.Activity;
import android.content.SharedPreferences;

public class GetSharedPreferences {
    private  SharedPreferences sharedPreferences;
    private Activity activity;

    public   GetSharedPreferences(Activity activity) {
        this.activity = activity;
    }

    public  SharedPreferences getSession() {
        sharedPreferences = activity.getApplicationContext().getSharedPreferences("session" , 0);
        return sharedPreferences;
    }

    public void setSession(String id, String mailadres,String tc) {
        sharedPreferences = activity.getApplicationContext().getSharedPreferences("session" , 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id",id);
        editor.putString("mailadres",mailadres);
        editor.putString("tc",tc);
        editor.commit();

    }
}

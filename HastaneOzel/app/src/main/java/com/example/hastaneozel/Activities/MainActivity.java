package com.example.hastaneozel.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.hastaneozel.Fragments.HomeFragment;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.Utils.ChangeFragments;
import com.example.hastaneozel.RestApi.Utils.GetSharedPreferences;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences getSharedPreferences;
    private GetSharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragment();
        tanimla();
        kontrol();
    }

    private void getFragment() {
        ChangeFragments changeFragments = new ChangeFragments(MainActivity.this);
        changeFragments.change(new HomeFragment());
    }

    public void tanimla() {
        preferences = new GetSharedPreferences(MainActivity.this);
        getSharedPreferences = preferences.getSession();
    }

    public void kontrol() {
        if(getSharedPreferences.getString("id",null) ==null && getSharedPreferences.getString("mailadres",null) ==null
        && getSharedPreferences.getString("tc",null) ==null){
            Intent intent = new Intent(MainActivity.this, GirisYapActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

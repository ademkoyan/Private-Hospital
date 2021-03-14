package com.example.hastaneozel.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hastaneozel.Models.LoginModel;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.ManagerAll;
import com.example.hastaneozel.RestApi.Utils.GetSharedPreferences;
import com.example.hastaneozel.RestApi.Utils.Warnings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GirisYapActivity extends AppCompatActivity {

    private EditText loginMailAdres,loginPassword;
    private TextView loginText;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);
        tanimla();
        click();
    }

    public void tanimla() {

        loginMailAdres = (EditText)findViewById(R.id.loginMailAdres);
        loginPassword = (EditText)findViewById(R.id.loginPassword);
        loginText = (TextView)findViewById(R.id.loginText);
        loginButton = (Button) findViewById(R.id.loginButton);


    }

    public void click() {

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = loginMailAdres.getText().toString();
                String pass = loginPassword.getText().toString();
                login(mail,pass);

            }
        });
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (GirisYapActivity.this , KayitActivity.class) ;
                startActivity(intent);
                finish();

            }
        });
    }


   /* private String login(String toString) {
    }*/

    public void login(String mailAdres, String parola) {
       Call<LoginModel> req =  ManagerAll.getInstance().girisYap(mailAdres,parola);
       req.enqueue(new Callback<LoginModel>() {
           @Override
           public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
               if (response.body().isTf()) {
                   Toast.makeText(getApplicationContext(),response.body().getText(),Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(GirisYapActivity.this , GirisYapActivity.class);
                   GetSharedPreferences getSharedPreferences = new GetSharedPreferences(GirisYapActivity.this);
                   getSharedPreferences.setSession(response.body().getId(),response.body().getTc(),response.body().getMailadres());
                   startActivity(intent);
                   finish();
               } else {
                   Toast.makeText(getApplicationContext(),response.body().getText(),Toast.LENGTH_LONG).show();

               }

           }

           @Override
           public void onFailure(Call<LoginModel> call, Throwable t) {
               Toast.makeText(getApplicationContext(), Warnings.internetProblemText, Toast.LENGTH_LONG).show();

           }
       });

    }
}

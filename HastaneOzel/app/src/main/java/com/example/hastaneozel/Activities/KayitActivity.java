package com.example.hastaneozel.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.DnsResolver;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hastaneozel.Models.RegisterPojo;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.ManagerAll;
import com.example.hastaneozel.RestApi.Utils.Warnings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.hastaneozel.RestApi.ManagerAll.getInstance;

public class KayitActivity extends AppCompatActivity {

    private Button kayitOlButton;
    private EditText registerPassword,registerMailAdress,registerTC,registerUserName;
    private TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        tanimla();
        registerToUser();
        chanceActivity();
    }

    public void tanimla(){
        kayitOlButton = (Button)findViewById(R.id.kayitOlButton);
        registerPassword = (EditText)findViewById(R.id.registerPassword);
        registerMailAdress = (EditText)findViewById(R.id.registerMailAdress);
        registerTC = (EditText)findViewById(R.id.registerTC);
        registerUserName = (EditText)findViewById(R.id.registerUserName);
        registerText = (TextView) findViewById(R.id.registerText);
    }

    public void registerToUser(){
        kayitOlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = registerMailAdress.getText().toString();
                String userN = registerUserName.getText().toString();
                String pass = registerPassword.getText().toString();
                String tc = registerTC.getText().toString();
                register(mail,userN,pass,tc);


            }
        });
    }

    public void chanceActivity(){
        registerText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KayitActivity.this , GirisYapActivity.class);
                startActivity(intent);
                finish();
            }


        });
    }

    public void register(String userName,String userMailAdress, String userTC ,String userPass){
        Call<RegisterPojo> req = ManagerAll.getInstance().kayitOl(userName, userMailAdress, userTC, userPass);
        req.enqueue(new Callback<com.example.hastaneozel.Models.RegisterPojo>() {
          @Override
          public void onResponse(Call<com.example.hastaneozel.Models.RegisterPojo> call, Response<com.example.hastaneozel.Models.RegisterPojo> response) {
                if(response.body().isTf()){
                    Toast.makeText(getApplicationContext(),response.body().getText(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(KayitActivity.this , GirisYapActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(getApplicationContext(),response.body().getText(),Toast.LENGTH_LONG).show();
                }
          }

          @Override
          public void onFailure(Call<com.example.hastaneozel.Models.RegisterPojo> call, Throwable t) {
              Toast.makeText(getApplicationContext(), Warnings.internetProblemText, Toast.LENGTH_LONG).show();

          }
      });

    }

}

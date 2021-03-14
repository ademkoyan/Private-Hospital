package com.example.hastaneozel.RestApi;

import com.example.hastaneozel.Models.DokModel;
import com.example.hastaneozel.Models.KampanyaModel;
import com.example.hastaneozel.Models.LoginModel;
import com.example.hastaneozel.Models.RegisterPojo;
import com.example.hastaneozel.Models.TahlilModel;
import com.example.hastaneozel.Models.YonetimModel;

import java.util.List;

import retrofit2.Call;


public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<RegisterPojo> kayitOl(String hasta_adı, String hasta_mail, String hasta_tc, String hasta_şifre) {
        Call<RegisterPojo> x = getRestApi().registerUser(hasta_adı, hasta_mail, hasta_tc, hasta_şifre);
        return x;

    }

    public Call<LoginModel> girisYap(String hasta_mail, String hasta_şifre) {
        Call<LoginModel> x = getRestApi().loginUser(hasta_mail,hasta_şifre);
        return x;

    }

    public Call<List<DokModel>> getDoks() {
        Call<List<DokModel>> x = getRestApi().getDoks();
        return x;

    }

    public Call<List<TahlilModel>> getTahlil(String hasta_tc) {
        Call<List<TahlilModel>> x = getRestApi().getTahlil(hasta_tc);
        return x;

    }

    public Call<List<YonetimModel>> getYonetim() {
        Call<List<YonetimModel>> x = getRestApi().getYonetim();
        return x;

    }

    public Call<List<KampanyaModel>> getKampanya() {
        Call<List<KampanyaModel>> x = getRestApi().getKampanya();
        return x;
    }
}

package com.example.hastaneozel.RestApi;

import com.example.hastaneozel.Models.DokModel;
import com.example.hastaneozel.Models.KampanyaModel;
import com.example.hastaneozel.Models.LoginModel;
import com.example.hastaneozel.Models.RegisterPojo;
import com.example.hastaneozel.Models.TahlilModel;
import com.example.hastaneozel.Models.YonetimModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("/kayitol.php")
    Call<RegisterPojo> registerUser(@Field("hasta_adı") String hasta_adı, @Field("hasta_mail") String hasta_mail, @Field("hasta_tc") String hasta_tc, @Field("hasta_şifre") String hasta_şifre);


    @FormUrlEncoded
    @POST("/girisyap.php")
    Call<LoginModel> loginUser(@Field("mailadres") String hasta_mail, @Field("parola") String hasta_şifre);


    @GET("/doktorlarım.php")
    Call<List<DokModel>> getDoks();

    @FormUrlEncoded
    @POST("/tahlil.php")
    Call<List<TahlilModel>> getTahlil(@Field("hasta_tc") String hasta_tc);


    @GET("/yonetim.php")
    Call<List<YonetimModel>> getYonetim();


    @GET("/kampanya.php")
    Call<List<KampanyaModel>> getKampanya();

}

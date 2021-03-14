package com.example.hastaneozel.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hastaneozel.Activities.Adapters.DoktorAdapter;
import com.example.hastaneozel.Models.DokModel;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.ManagerAll;
import com.example.hastaneozel.RestApi.Utils.ChangeFragments;
import com.example.hastaneozel.RestApi.Utils.Warnings;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DokFragment extends Fragment {

    View view;
    private RecyclerView doktorlistrecyclerview;
    private DoktorAdapter doktorAdapter;
    private  List<DokModel> dokModelList;
    private ChangeFragments changeFragments;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dok, container, false);
        tanimla();
        getDoks();
        return view;
    }



    public void tanimla(){

        dokModelList = new ArrayList<>();
        doktorlistrecyclerview = view.findViewById(R.id.doktorlistrecyclerview);
        RecyclerView.LayoutManager mng = new GridLayoutManager(getContext(), 2);
        doktorlistrecyclerview.setLayoutManager(mng);
        changeFragments = new ChangeFragments(getContext());

    }



    public void getDoks(){
        Call<List<DokModel>> req = ManagerAll.getInstance().getDoks();
        req.enqueue(new Callback<List<DokModel>>() {
            @Override
            public void onResponse(Call<List<DokModel>> call, Response<List<DokModel>> response) {
                if(response.body().get(0).isTf()){

                    dokModelList = response.body();
                    doktorAdapter = new DoktorAdapter(dokModelList, getContext());
                    doktorlistrecyclerview.setAdapter(doktorAdapter);
                    Toast.makeText(getContext(), "Hastanemizde toplam"+dokModelList.size()+"adet doktor bulunmaktadır..", Toast.LENGTH_LONG).show();

                }

                else{
                    Toast.makeText(getContext(), "Sistemde kayıtlı doktor yoktur..", Toast.LENGTH_LONG).show();
                    changeFragments.change(new HomeFragment());
                }
            }

            @Override
            public void onFailure(Call<List<DokModel>> call, Throwable t) {
                Toast.makeText(getContext(), Warnings.internetProblemText, Toast.LENGTH_LONG).show();

            }
        });
    }
}

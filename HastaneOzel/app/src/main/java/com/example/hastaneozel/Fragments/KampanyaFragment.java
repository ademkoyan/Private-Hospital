package com.example.hastaneozel.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hastaneozel.Activities.Adapters.KampanyaAdapter;
import com.example.hastaneozel.Models.KampanyaModel;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.ManagerAll;
import com.example.hastaneozel.RestApi.Utils.ChangeFragments;
import com.example.hastaneozel.RestApi.Utils.Warnings;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class KampanyaFragment extends Fragment {

    private View view;
    private RecyclerView kampanyaRecView;
    private ChangeFragments changeFragments;
    private KampanyaAdapter kampanyaAdapter;
    private List<KampanyaModel> kampanyaModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_kampanya, container, false);
        tanimla();
        getKampanya();
        return view;
    }

    public void tanimla(){
        kampanyaRecView = (RecyclerView)view.findViewById(R.id.kampanyaRecView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        kampanyaRecView.setLayoutManager(layoutManager);
        changeFragments = new ChangeFragments(getContext());
        kampanyaModelList = new ArrayList<>();
    }

    public void getKampanya(){
        Call<List<KampanyaModel>> req = ManagerAll.getInstance().getKampanya();
        req.enqueue(new Callback<List<KampanyaModel>>() {
            @Override
            public void onResponse(Call<List<KampanyaModel>> call, Response<List<KampanyaModel>> response) {
                if(response.body().get(0).isTf()){
                    kampanyaModelList = response.body();
                    kampanyaAdapter = new KampanyaAdapter(kampanyaModelList,getContext());
                    kampanyaRecView.setAdapter(kampanyaAdapter);

                }
                else{
                    Toast.makeText(getContext(), "Herhangi bir kampanya bulunmamaktadır.",Toast.LENGTH_LONG).show();
                    changeFragments.change(new HomeFragment());
                }
            }

            @Override
            public void onFailure(Call<List<KampanyaModel>> call, Throwable t) {
                Toast.makeText(getContext(), Warnings.internetProblemText,Toast.LENGTH_LONG).show();
            }
        });
    }
}

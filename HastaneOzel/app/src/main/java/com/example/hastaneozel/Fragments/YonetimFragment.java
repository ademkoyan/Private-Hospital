package com.example.hastaneozel.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hastaneozel.Activities.Adapters.YonetimAdapter;
import com.example.hastaneozel.Models.TahlilModel;
import com.example.hastaneozel.Models.YonetimModel;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.ManagerAll;
import com.example.hastaneozel.RestApi.Utils.ChangeFragments;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class YonetimFragment extends Fragment {

    View view;
    private RecyclerView yonetimlistrecyclerview;
    private YonetimAdapter yonetimAdapter;
    private List<YonetimModel> yonetimModelList;
    private ChangeFragments changeFragments;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_yonetim, container, false);
        tanimla();
        getYonetim();
        return view;
    }

    public void tanimla(){

        yonetimModelList = new ArrayList<>();
        yonetimlistrecyclerview = view.findViewById(R.id.yonetimlistrecyclerview);
        RecyclerView.LayoutManager mng = new GridLayoutManager(getContext(), 2);
        yonetimlistrecyclerview.setLayoutManager(mng);
        changeFragments = new ChangeFragments(getContext());

    }

    public void getYonetim (){
        retrofit2.Call<List<YonetimModel>> req = ManagerAll.getInstance().getYonetim();
        req.enqueue(new Callback<List<YonetimModel>>() {
            @Override
            public void onResponse(retrofit2.Call<List<YonetimModel>> call, Response<List<YonetimModel>> response) {
                if(response.body().get(0).isTf()){

                    yonetimModelList = response.body();
                    yonetimAdapter = new YonetimAdapter(yonetimModelList, getContext());
                    yonetimlistrecyclerview.setAdapter(yonetimAdapter);

                }

                else{
                    changeFragments.change(new HomeFragment());
                }
            }

            @Override
            public void onFailure(Call<List<YonetimModel>> call, Throwable t) {

            }
        });
    }
}

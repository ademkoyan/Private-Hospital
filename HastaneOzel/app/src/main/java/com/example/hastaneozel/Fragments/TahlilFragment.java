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
import com.example.hastaneozel.Activities.Adapters.TahlilAdapter;
import com.example.hastaneozel.Models.DokModel;
import com.example.hastaneozel.Models.TahlilModel;
import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.ManagerAll;
import com.example.hastaneozel.RestApi.Utils.ChangeFragments;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TahlilFragment extends Fragment {


    View view;
    private RecyclerView tahlillistrecyclerview;
    private TahlilAdapter tahlilAdapter;
    private List<TahlilModel> tahlilModelList;
    private ChangeFragments changeFragments;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_tahlil, container, false);
       tanimla();
       getTahlil("0");
       return view;
    }

    public void tanimla(){

        tahlilModelList = new ArrayList<>();
        tahlillistrecyclerview = view.findViewById(R.id.tahlillistrecyclerview);
        RecyclerView.LayoutManager mng = new GridLayoutManager(getContext(), 2);
        tahlillistrecyclerview.setLayoutManager(mng);
        changeFragments = new ChangeFragments(getContext());

    }

    public void getTahlil(String hasta_tc){
        Call<List<TahlilModel>> req = ManagerAll.getInstance().getTahlil(hasta_tc);
        req.enqueue(new Callback<List<TahlilModel>>() {
            @Override
            public void onResponse(Call<List<TahlilModel>> call, Response<List<TahlilModel>> response) {
                if(response.body().get(0).isTf()){

                    tahlilModelList = response.body();
                    tahlilAdapter = new TahlilAdapter(tahlilModelList, getContext());
                    tahlillistrecyclerview.setAdapter(tahlilAdapter);
                    Toast.makeText(getContext(), "Toplam tahlil sayınız = "+tahlilModelList.size(), Toast.LENGTH_LONG).show();

                }

                else{
                    Toast.makeText(getContext(), "Sistemde kayıtlı tahlil sonucunuz yoktur..", Toast.LENGTH_LONG).show();
                    changeFragments.change(new HomeFragment());
                }
            }

            @Override
            public void onFailure(Call<List<TahlilModel>> call, Throwable t) {

            }
        });
    }
}

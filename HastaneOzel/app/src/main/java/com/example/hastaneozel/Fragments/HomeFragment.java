package com.example.hastaneozel.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hastaneozel.R;
import com.example.hastaneozel.RestApi.Utils.ChangeFragments;


public class HomeFragment extends Fragment {

    private  View view;
    private LinearLayout doktorlarımLayout, yonetimlayout, tahlillayout, kampanyaLinearLayout;
    private ChangeFragments changeFragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        tanimla();
        action();
        return view;
    }

    public void tanimla(){
        doktorlarımLayout = (LinearLayout)view.findViewById(R.id.doktorlarımLayout);
        yonetimlayout = (LinearLayout)view.findViewById(R.id.yonetimlayout);
        tahlillayout = (LinearLayout)view.findViewById(R.id.tahlillayout);
        kampanyaLinearLayout = (LinearLayout)view.findViewById(R.id.kampanyaLinearLayout);
        changeFragments = new ChangeFragments(getContext());
    }

    public void action(){
        doktorlarımLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragments.change(new DokFragment());
            }
        });

        yonetimlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragments.change(new YonetimFragment());
            }
        });

        tahlillayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragments.change(new TahlilFragment());
            }
        });

        kampanyaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragments.change(new KampanyaFragment());
            }
        });


    }


}

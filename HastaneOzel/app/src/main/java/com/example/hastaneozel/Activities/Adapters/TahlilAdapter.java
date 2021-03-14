package com.example.hastaneozel.Activities.Adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hastaneozel.Models.TahlilModel;
import com.example.hastaneozel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TahlilAdapter extends RecyclerView.Adapter<TahlilAdapter.ViewHolder>{

    List<TahlilModel> list;
    Context context;

    public TahlilAdapter(List<TahlilModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tahlillistitemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tahlillayouttahlilbol.setText(list.get(position).getTahlilbol().toString());
        holder.tahlillayouttahlildok.setText(list.get(position).getTahlildok().toString());
        holder.tahlillayouttahlilisim.setText(list.get(position).getTahlilisim().toString());

        Picasso.get().load(list.get(position).getTahlilresim()).into(holder.tahlillayoutimage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tahlillayouttahlilbol, tahlillayouttahlildok, tahlillayouttahlilisim;
        CircleImageView tahlillayoutimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tahlillayouttahlilbol = (TextView)itemView.findViewById(R.id.tahlillayouttahlilbol);
            tahlillayouttahlildok = (TextView)itemView.findViewById(R.id.tahlillayouttahlildok);
            tahlillayouttahlilisim =(TextView) itemView.findViewById(R.id.tahlillayouttahlilisim);

            tahlillayoutimage = (CircleImageView)itemView.findViewById(R.id.tahlillayoutimage);
        }
    }

}

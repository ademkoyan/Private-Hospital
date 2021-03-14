package com.example.hastaneozel.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hastaneozel.Models.YonetimModel;
import com.example.hastaneozel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class YonetimAdapter extends RecyclerView.Adapter<YonetimAdapter.ViewHolder> {

    List<YonetimModel> list;
    Context context;

    public YonetimAdapter(List<YonetimModel> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public YonetimAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yonetimlistitemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YonetimAdapter.ViewHolder holder, int position) {
        holder.yonetimlayoutyonetimunvan.setText(list.get(position).getYonetunvan().toString());
        holder.yonetimlayoutyonetimisim.setText(list.get(position).getYonetisim().toString());
        holder.yonetimlayoutyonetimmeslek.setText(list.get(position).getYonetmeslek().toString());

        Picasso.get().load(list.get(position).getYonetresim()).into(holder.yonetimlayoutimage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView yonetimlayoutyonetimunvan, yonetimlayoutyonetimisim, yonetimlayoutyonetimmeslek;
        CircleImageView yonetimlayoutimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yonetimlayoutyonetimunvan =(TextView) itemView.findViewById(R.id.yonetimlayoutyonetimunvan);
            yonetimlayoutyonetimisim = (TextView)itemView.findViewById(R.id.yonetimlayoutyonetimisim);
            yonetimlayoutyonetimmeslek =(TextView) itemView.findViewById(R.id.yonetimlayoutyonetimmeslek);

            yonetimlayoutimage = (CircleImageView)itemView.findViewById(R.id.yonetimlayoutimage);
        }
    }
}

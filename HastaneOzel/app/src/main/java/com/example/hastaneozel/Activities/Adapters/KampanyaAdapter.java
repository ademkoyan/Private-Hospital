package com.example.hastaneozel.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hastaneozel.Models.KampanyaModel;
import com.example.hastaneozel.Models.YonetimModel;
import com.example.hastaneozel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class KampanyaAdapter extends RecyclerView.Adapter<KampanyaAdapter.ViewHolder> {

    List<KampanyaModel> list;
    Context context;

    public KampanyaAdapter(List<KampanyaModel> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public KampanyaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kampanyaitemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KampanyaAdapter.ViewHolder holder, int position) {

        holder.kampanyaBaslikText.setText(list.get(position).getBaslik().toString());
        holder.kampanyatext.setText(list.get(position).getText().toString());

        Picasso.get().load(list.get(position).getResim()).into(holder.kampanyaImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView kampanyaBaslikText, kampanyatext;
        ImageView kampanyaImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kampanyaBaslikText =(TextView) itemView.findViewById(R.id.kampanyaBaslikText);
            kampanyatext = (TextView)itemView.findViewById(R.id.kampanyatext);

            kampanyaImageView = (ImageView)itemView.findViewById(R.id.kampanyaImageView);
        }
    }
}

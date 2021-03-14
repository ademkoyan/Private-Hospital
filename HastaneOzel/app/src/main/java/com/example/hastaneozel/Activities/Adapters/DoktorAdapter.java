package com.example.hastaneozel.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hastaneozel.Models.DokModel;
import com.example.hastaneozel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoktorAdapter extends RecyclerView.Adapter<DoktorAdapter.ViewHolder>{


    List<DokModel> list;
    Context context;

    public DoktorAdapter(List<DokModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doklistitemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.doktorlayoutdoktorbolum.setText(list.get(position).getDokbol().toString());
        holder.doktorlayoutdoktorisim.setText(list.get(position).getDokisim().toString());
        holder.doktorlayoutdoktortur.setText(list.get(position).getDoktur().toString());

        Picasso.get().load(list.get(position).getDokresim()).into(holder.doktorlayoutimage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView doktorlayoutdoktorbolum,doktorlayoutdoktorisim,doktorlayoutdoktortur;
        CircleImageView doktorlayoutimage;

        //itemView ile listview in her elemanı için layout ile oluşturduğumuz viewin tanımlanması işlemi gerçekleşecek
        public ViewHolder(View itemView) {
            super(itemView);

            doktorlayoutdoktorbolum = (TextView)itemView.findViewById(R.id.doktorlayoutdoktorbolum);
            doktorlayoutdoktorisim = (TextView)itemView.findViewById(R.id.doktorlayoutdoktorisim);
            doktorlayoutdoktortur = (TextView)itemView.findViewById(R.id.doktorlayoutdoktortur);

            doktorlayoutimage = (CircleImageView)itemView.findViewById(R.id.doktorlayoutimage);
        }

    }


}

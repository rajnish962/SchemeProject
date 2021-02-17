package com.rajnish.tspschemes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    List<Scheme> list;
    Context context;

    public MyAdapter(Context context, List<Scheme> list) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyHolder myHolder=new MyHolder(view);


        return myHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Scheme scheme=list.get(position);


        holder.id.setText(scheme.getId());
        holder.scheme.setText(scheme.getScheme());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView id,scheme;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.tv_id);
            scheme=itemView.findViewById(R.id.tv_data);

        }
    }
}

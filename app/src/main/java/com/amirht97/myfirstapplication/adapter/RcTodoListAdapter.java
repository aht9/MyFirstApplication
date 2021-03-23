package com.amirht97.myfirstapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amirht97.myfirstapplication.R;
import com.amirht97.myfirstapplication.model.Result;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import java.util.List;

public class RcTodoListAdapter extends RecyclerView.Adapter<RcTodoListAdapter.MyViewHolder> {
    Context context;
    List<Result> data;

    public RcTodoListAdapter(Context context, List<Result> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.todo_list_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Result result = data.get(position);
        holder.txt_Todo_Title.setText(result.getTitle());
        holder.txt_Todo_Des.setText(result.getDescription());

        Glide.with(context)
                .load(result.getImage())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.img_Todo_pic);

        if(result.getDoItCheck())
        {
            holder.img_color_warning.setBaseline(R.color.green_color);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_color_warning,img_Todo_pic;
        TextView txt_Todo_Title,txt_Todo_Des;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_color_warning = itemView.findViewById(R.id.img_color_warning);
            img_Todo_pic = itemView.findViewById(R.id.img_Todo_pic);
            txt_Todo_Title = itemView.findViewById(R.id.txt_Todo_Title);
            txt_Todo_Des = itemView.findViewById(R.id.txt_Todo_Des);
        }
    }
}

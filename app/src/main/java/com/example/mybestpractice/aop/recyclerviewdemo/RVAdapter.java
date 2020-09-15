package com.example.mybestpractice.aop.recyclerviewdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybestpractice.R;

/**
 * @author :   yuxibing
 * @date :   2020-08-26
 * Describe :
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewholder> {

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item, null);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        TextView text = holder.itemView.findViewById(R.id.text);
//        text.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MyViewholder extends RecyclerView.ViewHolder {

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

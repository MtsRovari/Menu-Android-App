package com.foodproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.model.Extra;

import java.util.ArrayList;
import java.util.List;

public class ExtrasAdapter extends RecyclerView.Adapter<ExtrasAdapter.ItemHolder>{

    private static String TAG = "ExtrasAdapter";

    private List<Extra> extras = new ArrayList<>();
    private Context context;
    private final OnExtraClickListener mListener;

    private String[] extrasNames = {"Tuna, Salmon, Wasabi, Unagi, Vegetables, Noodles"};
    private String[] extrasValues = {"35", "20", "25", "10", "5", "30"};

    public ExtrasAdapter(Context context){
        this.context = context;

        try {
            this.mListener = ((OnExtraClickListener) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement OnPlaceClickListener.");
        }

        for (int i = 0; i < 6; i++){
            Extra extra = new Extra("Extra " + (i + 1), "$" + (i + 1) + ".00");
            extras.add(extra);
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.extra_item, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Extra extra =  extras.get(position);

        holder.mExtraName.setText(extra.getExtraName());
        holder.mExtraValue.setText(extra.getExtraValue());
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mExtraName, mExtraValue;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            mExtraName = itemView.findViewById(R.id.extra_name);
            mExtraValue = itemView.findViewById(R.id.extra_value);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked Item", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return extras.size();
    }

    public interface OnExtraClickListener {
        void OnExtraClickListener(Extra extra);
    }
}

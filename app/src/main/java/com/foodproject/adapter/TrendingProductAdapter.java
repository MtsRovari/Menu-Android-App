package com.foodproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.model.Products;

import java.util.ArrayList;
import java.util.List;

public class TrendingProductAdapter extends RecyclerView.Adapter<TrendingProductAdapter.ItemHolder>{

    private List<Products> products = new ArrayList<>();
    private Context context;
    private final OnClickItemListner mListener;

    public TrendingProductAdapter(Context context){
        this.context = context;

        try {
            this.mListener = ((OnClickItemListner) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement OnClickItemListner.");
        }

        for (int i = 0; i < 30; i++){
            Products prod = new Products("Product " + (i + 1), "Description " + (i + 1),
                     "Restaurant " + (i + 1), "Product Value R$" + (i + 1) + ",00");
            products.add(prod);
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_trending_card, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, int position) {
        final Products prod =  products.get(position);

        holder.mProductName.setText(prod.getmProductName());
        holder.mProductDescription.setText(prod.getmProductDescription());

        holder.mNoFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener  != null){
                    mListener.onNoFavoriteClick(prod);
                    holder.mNoFavorite.setVisibility(View.GONE);
                    holder.mFavorite.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener  != null){
                    mListener.onFavoriteClick(prod);
                    holder.mNoFavorite.setVisibility(View.VISIBLE);
                    holder.mFavorite.setVisibility(View.GONE);
                }
            }
        });
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mProductName, mProductDescription, mProductValue, mProductRestaurant;
        public ImageView mNoFavorite, mFavorite;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            mProductName = itemView.findViewById(R.id.product_name);
            mProductDescription = itemView.findViewById(R.id.product_description);
            mFavorite = itemView.findViewById(R.id.favorite);
            mNoFavorite = itemView.findViewById(R.id.no_favorite);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked Item", Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnClickItemListner {
        void onNoFavoriteClick(Products products);
        void onFavoriteClick(Products products);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

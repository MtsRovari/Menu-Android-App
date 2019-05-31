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
import com.foodproject.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProductsAdapter extends RecyclerView.Adapter<FavoriteProductsAdapter.ItemHolder>{

    private List<Product> products = new ArrayList<>();
    private Context context;
    private final OnProductClickListener mListener;

    public FavoriteProductsAdapter(Context context){
        this.context = context;

        try {
            this.mListener = ((OnProductClickListener) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement OnPlaceClickListener.");
        }

        String[] favoriteFoodNames = {"Clássico", "Cheese", "Cheddar",
                "Picanha", "Double", "Big Cheese", "X Bacon", "Duplo Bacon", "Hot Dog", "Premium"};

        String[] favoriteFoodPlaces = {"Chipotle", "Five Guys",
                "Starbucks", "Subway", "Dunkin Donuts", "Habbib's", "Mac Donalds", "Chipotle", "Starbucks", "Dunkin Donuts"};

        String[] favoriteFoodPrices = {"19,99", "26,00", "15,00",
                "32,00", "20,00", "22,50", "17,99", "23,00", "32,00", "34,00"};

        for (int i = 0; i < 10; i++){
            Product prod = new Product(favoriteFoodNames[i], "Description " + (i + 1),
                    favoriteFoodPlaces[i], "R$" + favoriteFoodPrices[i]);
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
        final Product prod =  products.get(position);

        holder.mProductName.setText(prod.getmProductName());
        holder.mProductDescription.setText(prod.getmProductRestaurant());
        holder.mProductValue.setText(prod.getmProductValue());

        holder.mNoFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener  != null){
                    mListener.OnProductFavoriteClick(prod);
                    holder.mNoFavorite.setVisibility(View.GONE);
                    holder.mFavorite.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener  != null){
                    mListener.OnProductNoFavoriteClick(prod);
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

    public interface OnProductClickListener {
        void OnProductNoFavoriteClick(Product products);
        void OnProductFavoriteClick(Product products);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

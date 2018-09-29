package com.foodproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.model.Categories;
import com.foodproject.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemHolder>{

    private List<Products> products = new ArrayList<>();
    private Context context;

    public ProductAdapter(Context context){
        this.context = context;

        for (int i = 0; i < 100; i++){
            Products prod = new Products("Product " + (i + 1), "Description " + (i + 1),
                     "Restaurant " + (i + 1), "Product Value R$" + (i + 1) + ",00");
            products.add(prod);
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_card, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Products prod =  products.get(position);

        holder.mProductName.setText(prod.getmProductName());
        holder.mProductDescription.setText(prod.getmProductDescription());
        holder.mProductValue.setText(prod.getmProductValue());
        holder.mProductRestaurant.setText(prod.getmProductRestaurant());
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mProductName, mProductDescription, mProductValue, mProductRestaurant;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            mProductName = itemView.findViewById(R.id.product_name);
            mProductDescription = itemView.findViewById(R.id.product_description);
            mProductValue = itemView.findViewById(R.id.product_value);
            mProductRestaurant = itemView.findViewById(R.id.product_restaurant);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked Item", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}

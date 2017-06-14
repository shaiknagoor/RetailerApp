package com.biz.stampit.retailerapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biz.stampit.retailerapp.ProductActivity;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by Stampit-PC1 on 5/31/2017.
 */

public class GroceryAndStaplesRecyclerViewAdapter extends  RecyclerView.Adapter<GroceryAndStapleRecyclerViewHolder> {


    private static final String TAG = GroceryAndStaplesRecyclerViewAdapter.class.getSimpleName();

    private Context context;

    private List<ProductObject> allProducts;
    public GroceryAndStaplesRecyclerViewAdapter(Context context, List<ProductObject> allProducts) {
        this.context = context;
        this.allProducts = allProducts;
    }

    public GroceryAndStaplesRecyclerViewAdapter(FragmentActivity activity, List<ProductObject> allProductsOnSale) {
        this.context = activity;
        this.allProducts = allProductsOnSale;
    }

    @Override
    public GroceryAndStapleRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_list, parent, false);
        GroceryAndStapleRecyclerViewHolder productHolder = new GroceryAndStapleRecyclerViewHolder(layoutView);

        return productHolder;
    }

    @Override
    public void onBindViewHolder(GroceryAndStapleRecyclerViewHolder holder, int position) {
        final ProductObject singleProduct = allProducts.get(position);

        holder.productName.setText(singleProduct.getProductName());
        holder.produceImage.setImageResource(singleProduct.getProductImage());
        holder.Description.setText(singleProduct.getProductDescription());

        holder.produceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productIntent = new Intent(context, ProductActivity.class);

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();

                String stringObjectRepresentation = gson.toJson(singleProduct);

                productIntent.putExtra("PRODUCT", stringObjectRepresentation);
                context.startActivity(productIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allProducts.size();
    }
}

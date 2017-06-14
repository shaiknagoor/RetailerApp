package com.biz.stampit.retailerapp.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biz.stampit.retailerapp.Fragments.HouseholdFragment;
import com.biz.stampit.retailerapp.ProductActivity;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by Lenovo on 6/5/2017.
 */

public class HouseholdRecyclerViewAdapter extends RecyclerView.Adapter<HouseholdViewHolder> {
    public static String TAG = HouseholdRecyclerViewAdapter.class.getName();
    private final Context context;
    private List<ProductObject>allProducts;

    public HouseholdRecyclerViewAdapter(Context context, List<ProductObject> allProducts){
        this.context =context;
        this.allProducts =allProducts;
    }
    public HouseholdRecyclerViewAdapter(FragmentActivity activity,List<ProductObject> allProductsOnScale){
        this.context=activity;
        this.allProducts=allProductsOnScale;
    }

    @Override
    public HouseholdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_list, parent, false);
        HouseholdViewHolder ProductHolder = new HouseholdViewHolder(layoutView);
        return ProductHolder;
    }

    @Override
    public void onBindViewHolder(HouseholdViewHolder holder, int position) {
        final ProductObject singleProduct = allProducts.get(position);
        holder.productName.setText(singleProduct.getProductName());
        holder.Description.setText(singleProduct.getProductDescription());
        holder.produceImage.setImageResource(singleProduct.getProductImage());
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

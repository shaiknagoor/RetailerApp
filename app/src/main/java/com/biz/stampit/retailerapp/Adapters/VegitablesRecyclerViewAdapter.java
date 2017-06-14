package com.biz.stampit.retailerapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biz.stampit.retailerapp.entities.ProductObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.biz.stampit.retailerapp.ProductActivity;
import com.biz.stampit.retailerapp.R;
import com.biz.stampit.retailerapp.entities.ProductObject;

import java.util.List;

public class VegitablesRecyclerViewAdapter extends RecyclerView.Adapter<VegitableRecyclerViewHolder>{

    private static final String TAG = VegitablesRecyclerViewAdapter.class.getSimpleName();

    private Context context;
    String[] result;
    int[] imageId;
    String[] Cost;
    static int counter = 0;
    private static LayoutInflater inflater = null;


    private List<ProductObject> allProducts;

    public VegitablesRecyclerViewAdapter(Context context, List<ProductObject> allProducts) {
        this.context = context;
        this.allProducts = allProducts;
    }

    public VegitablesRecyclerViewAdapter(FragmentActivity activity, List<ProductObject> allProductsOnSale) {
        this.context = activity;
        this.allProducts = allProductsOnSale;
    }

    @Override
    public VegitableRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_list, parent, false);
        VegitableRecyclerViewHolder productHolder = new VegitableRecyclerViewHolder(layoutView);
        return productHolder;
    }




    @Override
    public void onBindViewHolder(final VegitableRecyclerViewHolder holder, int position) {
        final ProductObject singleProduct = allProducts.get(position);
        holder.add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                holder.item_count.setText(String.valueOf(counter));
            }
        });
        holder.remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                holder.item_count.setText(String.valueOf(counter));
            }
        });
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

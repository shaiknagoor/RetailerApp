package com.biz.stampit.retailerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.biz.stampit.retailerapp.R;

/**
 * Created by Stampit-PC1 on 5/31/2017.
 */

class GroceryAndStapleRecyclerViewHolder extends RecyclerView.ViewHolder {


    public ImageView produceImage;

    public TextView productName;
    public TextView Description;


    public GroceryAndStapleRecyclerViewHolder(View itemView) {
        super(itemView);
        produceImage =(ImageView)itemView.findViewById(R.id.product_image);
        productName = (TextView)itemView.findViewById(R.id.product_name);
        Description=(TextView)itemView.findViewById(R.id.item_short_desc);
    }
}

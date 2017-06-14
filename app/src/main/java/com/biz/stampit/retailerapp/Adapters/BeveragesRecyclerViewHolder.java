package com.biz.stampit.retailerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.biz.stampit.retailerapp.R;

public class BeveragesRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView produceImage;
    public TextView Description;

    public TextView productName;

    public BeveragesRecyclerViewHolder(View itemView) {
        super(itemView);
        produceImage =(ImageView)itemView.findViewById(R.id.product_image);
        productName = (TextView)itemView.findViewById(R.id.product_name);
        Description=(TextView)itemView.findViewById(R.id.item_short_desc);
    }
}

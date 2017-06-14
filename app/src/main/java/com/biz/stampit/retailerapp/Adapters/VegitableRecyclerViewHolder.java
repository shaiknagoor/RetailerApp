package com.biz.stampit.retailerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.EventLogTags;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.biz.stampit.retailerapp.R;

public class VegitableRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView produceImage;

    public TextView productName;
    public TextView Description;
    public  TextView add_item;
    public  TextView remove_item;
    public  TextView item_count;


    public VegitableRecyclerViewHolder(View itemView) {
        super(itemView);
        produceImage =(ImageView)itemView.findViewById(R.id.product_image);
        productName = (TextView)itemView.findViewById(R.id.product_name);
        add_item=(TextView)itemView.findViewById(R.id.add_item);
        remove_item=(TextView)itemView.findViewById(R.id.remove_item);
        item_count=(TextView)itemView.findViewById(R.id.iteam_amount);
        Description=(TextView)itemView.findViewById(R.id.item_short_desc);
    }
}
